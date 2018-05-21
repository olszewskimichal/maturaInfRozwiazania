package pl.michal.olszewski.matury.pp2017;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pp2017.zad5.SplitLineToWynajemPOJO;
import pl.michal.olszewski.matury.pp2017.zad5.Wynajem;

public class Zadanie5 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 5 - Matura 2017");
    Map<Long, Long> collect = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToWynajemPOJO::split)
        .map(Wynajem::getTyp)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Long najczestszyTyp = collect.entrySet().stream().max(Comparator.comparing(Entry::getValue))
        .orElseThrow(() -> new IllegalArgumentException("nieprawidlowa wartosc")).getKey();
    System.out.println("Najczesciej wynajmowany typ to " + najczestszyTyp);

    Map<Long, List<Wynajem>> wynajemPerTyp = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToWynajemPOJO::split)
        .collect(Collectors.groupingBy(Wynajem::getTyp));

    System.out.println("Typ domku - ilosc dób");
    for (Entry<Long, List<Wynajem>> entry : wynajemPerTyp.entrySet()) {
      int sumaDob = entry.getValue()
          .stream()
          .map(v -> ChronoUnit.DAYS.between(v.getDataPrzyjazdu(), v.getDataWyjazdu()))
          .mapToInt(Long::intValue)
          .sum();
      System.out.println(entry.getKey() + " " + sumaDob);
    }

    System.out.println("Zad 5c");
    for (Entry<Long, List<Wynajem>> entry : wynajemPerTyp.entrySet()) {
      BigDecimal reduce = entry.getValue()
          .stream()
          .map(Wynajem::sumaWydatkow)
          .reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(entry.getKey() + " " + reduce);
    }

    System.out.println("Zad 5d");
    Map<Month, List<Wynajem>> wynajemPerMiesiac = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToWynajemPOJO::split)
        .collect(Collectors.groupingBy(v -> v.getDataPrzyjazdu().getMonth()));

    for (Entry<Month, List<Wynajem>> entry : wynajemPerMiesiac.entrySet()) {
      BigDecimal sum = entry.getValue()
          .stream()
          .map(v -> v.getEnergia().add(v.getWoda()))
          .reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(entry.getKey() + " " + sum);
    }


  }


}
