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
import pl.michal.olszewski.matury.pp2017.zad6.Candidate;
import pl.michal.olszewski.matury.pp2017.zad6.SplitLineToVotePOJO;
import pl.michal.olszewski.matury.pp2017.zad6.SplitLineToCandidatePOJO;
import pl.michal.olszewski.matury.pp2017.zad6.SplitLineToStudentPOJO;
import pl.michal.olszewski.matury.pp2017.zad6.Student;

public class Zadanie6 {


  public static void main(String args[]) throws IOException {
    Set<Student> students = readAllStudentsFromFile();
    Set<Candidate> candidates = readAllCandidatesFromFile();
    updateVotes(students, candidates);

    System.out.println("Zad 6a");
    System.out.println("Dziewczyny " + countStudentsForPredicate(students, v -> v.getName().endsWith("a")));
    System.out.println("Mezczyzni " + countStudentsForPredicate(students, v -> !v.getName().endsWith("a")));

    System.out.println("Zad 6b");
    Set<Candidate> ppu = getPPU(candidates);
    ppu.stream()
        .sorted((e1, e2) -> Integer.compare(e2.getVotersId().size(), e1.getVotersId().size())).
        forEach(v -> System.out.println(v.getName() + " " + v.getLastName() + " " + v.getVotersId().size()));
    System.out.println("Zad 6c");
    System.out.println("Uczniow którzy nie wzieli udzialu w wyborach " + countStudentsForPredicate(students, v -> v.getIdZaglosowanychKandydatow().isEmpty()));
    System.out.println("Zad 6d");

    Map<Long, List<Student>> listMap = students.stream().collect(Collectors.groupingBy(Student::getRok));

    for (Entry<Long, List<Student>> entry : listMap.entrySet()) {
      int sum = entry
          .getValue().stream()
          .mapToInt(v -> v.getIdZaglosowanychKandydatow().size())
          .sum();
      long classCount = entry.getValue().stream()
          .map(Student::getClassSymbol)
          .distinct()
          .count();
      BigDecimal avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(classCount), 2, RoundingMode.HALF_UP);
      System.out.println(entry.getKey() + " " + avg);
    }

  }

  /**
   * PPU - Prezydium Parlamentu Uczniowskiego - składa się z 10 osób, które uzyskały największą liczbę głosów
   */
  private static Set<Candidate> getPPU(Set<Candidate> candidates) {
    return candidates.stream()
        .sorted((e1, e2) -> Integer.compare(e2.getVotersId().size(), e1.getVotersId().size()))
        .limit(10)
        .collect(Collectors.toSet());
  }

  private static long countStudentsForPredicate(Set<Student> students, Predicate<Student> predicate) {
    return students
        .stream()
        .filter(predicate)
        .count();
  }


  private static Set<Student> readAllStudentsFromFile() throws IOException {
    return Files.readAllLines(Paths.get("uczniowie.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToStudentPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Set<Candidate> readAllCandidatesFromFile() throws IOException {
    return Files.readAllLines(Paths.get("kandydaci.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToCandidatePOJO::split)
        .collect(Collectors.toSet());
  }

  private static Candidate findCandidateById(Long id, Set<Candidate> candidates) {
    return candidates
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono kandydata o id = " + id));
  }

  private static Student findStudentById(Long id, Set<Student> students) {
    return students
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono ucznia o id = " + id));
  }

  private static void updateVotes(Set<Student> students, Set<Candidate> candidates) throws IOException {
    Files.readAllLines(Paths.get("glosy.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToVotePOJO::split)
        .forEach(v -> {
          Long uczenId = v.getStudentId();
          Long kandydatId = v.getCandidateId();
          Candidate candidateById = findCandidateById(kandydatId, candidates);
          Student studentById = findStudentById(uczenId, students);
          studentById.getIdZaglosowanychKandydatow().add(kandydatId);
          candidateById.getVotersId().add(uczenId);
        });
  }


}
