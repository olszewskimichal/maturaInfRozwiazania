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
import pl.michal.olszewski.matury.pp2017.zad5.SplitLineToRentPOJO;
import pl.michal.olszewski.matury.pp2017.zad5.Rent;

public class Zadanie5 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 5 - Matura 2017");
    Map<Long, Long> collect = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToRentPOJO::split)
        .map(Rent::getType)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Long najczestszyTyp = collect.entrySet().stream().max(Comparator.comparing(Entry::getValue))
        .orElseThrow(() -> new IllegalArgumentException("nieprawidlowa wartosc")).getKey();
    System.out.println("Najczesciej wynajmowany typ to " + najczestszyTyp);

    Map<Long, List<Rent>> wynajemPerTyp = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToRentPOJO::split)
        .collect(Collectors.groupingBy(Rent::getType));

    System.out.println("Typ domku - ilosc dób");
    for (Entry<Long, List<Rent>> entry : wynajemPerTyp.entrySet()) {
      int sumaDob = entry.getValue()
          .stream()
          .map(v -> ChronoUnit.DAYS.between(v.getFrom(), v.getTo()))
          .mapToInt(Long::intValue)
          .sum();
      System.out.println(entry.getKey() + " " + sumaDob);
    }

    System.out.println("Zad 5c");
    for (Entry<Long, List<Rent>> entry : wynajemPerTyp.entrySet()) {
      BigDecimal reduce = entry.getValue()
          .stream()
          .map(Rent::sumaWydatkow)
          .reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(entry.getKey() + " " + reduce);
    }

    System.out.println("Zad 5d");
    Map<Month, List<Rent>> wynajemPerMiesiac = Files.readAllLines(Paths.get("wynajem.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToRentPOJO::split)
        .collect(Collectors.groupingBy(v -> v.getFrom().getMonth()));

    for (Entry<Month, List<Rent>> entry : wynajemPerMiesiac.entrySet()) {
      BigDecimal sum = entry.getValue()
          .stream()
          .map(v -> v.getEnergy().add(v.getWater()))
          .reduce(BigDecimal.ZERO, BigDecimal::add);
      System.out.println(entry.getKey() + " " + sum);
    }


  }


}
