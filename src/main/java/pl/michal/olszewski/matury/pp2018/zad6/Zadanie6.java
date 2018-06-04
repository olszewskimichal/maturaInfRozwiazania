package pl.michal.olszewski.matury.pp2018.zad6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Zadanie6 {

  public static void main(String[] args) throws IOException {
    System.out.println("Zadanie 6.1");
    readAllFromFiles().stream()
        .collect(Collectors.groupingBy(v -> v.getDate().getMonth()))
        .forEach((key, value) -> System.out.println(key + " " + sumOfMakulatura(value)));

    System.out.println("Zadanie 6.2");
    readAllFromFiles()
        .stream()
        .collect(Collectors.groupingBy(v -> v.getName() + " " + v.getLastName()))
        .entrySet()
        .stream()
        .max(Comparator.comparingInt(v2 -> sumOfMakulatura(v2.getValue())))
        .ifPresent(v -> System.out.println(v.getKey() + " " + sumOfMakulatura(v.getValue())));

    System.out.println("Zadanie 6.3");
    readAllFromFiles()
        .stream()
        .filter(v -> v.getDate().getDayOfWeek().equals(DayOfWeek.TUESDAY))
        .collect(Collectors.groupingBy(Makulatura::getDate))
        .entrySet()
        .stream()
        .filter(v -> !v.getValue().isEmpty())
        .forEach(v -> System.out.println(v.getKey() + " " + sumOfMakulatura(v.getValue())));

    LinkedHashMap<LocalDate, List<Makulatura>> collect = readAllFromFiles()
        .stream()
        .collect(Collectors.groupingBy(Makulatura::getDate))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Entry::getKey))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    int makulatura = 0;
    int i = 0;
    for (Entry<LocalDate, List<Makulatura>> entry : collect.entrySet()) {
      Integer sumOfMakulatura = sumOfMakulatura(entry.getValue());
      makulatura += sumOfMakulatura;
      if (entry.getKey().getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
        if (makulatura < 1200) {
          makulatura = 0;
        } else {
          System.out.println(entry.getKey());
          makulatura -= 1200;
          i++;
        }
      }
    }
    System.out.println("Zadanie 6.4 - wydarzylo się to " + i + " razy");
  }

  public static List<Makulatura> readAllFromFiles() throws IOException {
    return Files.readAllLines(Paths.get("makulatura.txt"), StandardCharsets.ISO_8859_1)
        .stream()
        .skip(1)
        .map(SplitLineToMakulatura::split)
        .collect(Collectors.toList());
  }

  public static Integer sumOfMakulatura(List<Makulatura> makulaturaList) {
    return makulaturaList
        .stream()
        .mapToInt(Makulatura::getKg)
        .sum();
  }

}
