package pl.michal.olszewski.matury.pp2017;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pp2017.zad6.Kandydat;
import pl.michal.olszewski.matury.pp2017.zad6.SplitLineToGlos;
import pl.michal.olszewski.matury.pp2017.zad6.SplitLineToKandydat;
import pl.michal.olszewski.matury.pp2017.zad6.SplitStringToUczen;
import pl.michal.olszewski.matury.pp2017.zad6.Uczen;

public class Zadanie6 {


  public static void main(String args[]) throws IOException {
    Set<Uczen> uczens = readAllStudentsFromFile();
    Set<Kandydat> candidates = readAllCandidatesFromFile();
    updateVotes(uczens, candidates);

    System.out.println("Zad 6a");
    System.out.println("Dziewczyny " + countStudentsForPredicate(uczens, v -> v.getName().endsWith("a")));
    System.out.println("Mezczyzni " + countStudentsForPredicate(uczens, v -> !v.getName().endsWith("a")));

    System.out.println("Zad 6b");
    Set<Kandydat> ppu = getPPU(candidates);
    ppu.stream()
        .sorted((e1, e2) -> Integer.compare(e2.getUczniowieGlosujacy().size(), e1.getUczniowieGlosujacy().size())).
        forEach(v -> System.out.println(v.getName() + " " + v.getLastName() + " " + v.getUczniowieGlosujacy().size()));
    System.out.println("Zad 6c");
    System.out.println("Uczniow którzy nie wzieli udzialu w wyborach " + countStudentsForPredicate(uczens, v -> v.getIdZaglosowanychKandydatow().isEmpty()));
    System.out.println("Zad 6d");

    Map<Long, List<Uczen>> listMap = uczens.stream().collect(Collectors.groupingBy(Uczen::getRok));

    for (Entry<Long, List<Uczen>> entry : listMap.entrySet()) {
      int sum = entry
          .getValue().stream()
          .mapToInt(v -> v.getIdZaglosowanychKandydatow().size())
          .sum();
      long classCount = entry.getValue().stream()
          .map(Uczen::getClassSymbol)
          .distinct()
          .count();
      BigDecimal avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(classCount), 2, RoundingMode.HALF_UP);
      System.out.println(entry.getKey() + " " + avg);
    }

  }

  /**
   * PPU - Prezydium Parlamentu Uczniowskiego - składa się z 10 osób, które uzyskały największą liczbę głosów
   */
  private static Set<Kandydat> getPPU(Set<Kandydat> candidates) {
    return candidates.stream()
        .sorted((e1, e2) -> Integer.compare(e2.getUczniowieGlosujacy().size(), e1.getUczniowieGlosujacy().size()))
        .limit(10)
        .collect(Collectors.toSet());
  }

  private static long countStudentsForPredicate(Set<Uczen> students, Predicate<Uczen> predicate) {
    return students
        .stream()
        .filter(predicate)
        .count();
  }


  private static Set<Uczen> readAllStudentsFromFile() throws IOException {
    return Files.readAllLines(Paths.get("uczniowie.txt"))
        .stream()
        .skip(1)
        .map(SplitStringToUczen::split)
        .collect(Collectors.toSet());
  }

  private static Set<Kandydat> readAllCandidatesFromFile() throws IOException {
    return Files.readAllLines(Paths.get("kandydaci.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToKandydat::split)
        .collect(Collectors.toSet());
  }

  private static Kandydat findCandidateById(Long id, Set<Kandydat> candidates) {
    return candidates
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono kandydata o id = " + id));
  }

  private static Uczen findStudentById(Long id, Set<Uczen> students) {
    return students
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono ucznia o id = " + id));
  }

  private static void updateVotes(Set<Uczen> students, Set<Kandydat> candidates) throws IOException {
    Files.readAllLines(Paths.get("glosy.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToGlos::split)
        .forEach(v -> {
          Long uczenId = v.getUczenId();
          Long kandydatId = v.getKandydatId();
          Kandydat candidateById = findCandidateById(kandydatId, candidates);
          Uczen studentById = findStudentById(uczenId, students);
          studentById.getIdZaglosowanychKandydatow().add(kandydatId);
          candidateById.getUczniowieGlosujacy().add(uczenId);
        });
  }


}
