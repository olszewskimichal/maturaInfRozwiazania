package pl.michal.olszewski.matury.pp2017.zad4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Zadanie4 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 4 - Matura 2017");
    long countSequenceAsc = getStreamWithStringArrayValuesFromFile()
        .filter(s -> SeqAscChecker.isValid(s[0], s[1], s[2]))
        .count();
    System.out.println("Wynik 4a to " + countSequenceAsc);

    long sumOfGCD = getStreamWithStringArrayValuesFromFile()
        .map(s -> GreatestCommonDivisor.calculate(s[0], s[1], s[2]))
        .mapToInt(v -> v)
        .sum();
    System.out.println("Wynik 4b to " + sumOfGCD);

    long howManyEqualTo35 = getStreamWithStringArrayValuesFromFile()
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .filter(v -> v.equals(35))
        .count();
    System.out.println("Wynik 4c to " + howManyEqualTo35);

    Integer maxValueInRow = getStreamWithStringArrayValuesFromFile()
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .max(Integer::compareTo)
        .orElse(0);

    long countMaxValueInFile = getStreamWithStringArrayValuesFromFile()
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .filter(v -> v.equals(maxValueInRow))
        .count();
    System.out.println("Wynik 4c -> Maksymalna wartosc to " + maxValueInRow + " która wystapila " + countMaxValueInFile);


  }

  private static Stream<String[]> getStreamWithStringArrayValuesFromFile() throws IOException {
    return readAllLinesFromFile()
        .stream()
        .map(Zadanie4::splitBySpace);
  }

  private static List<String> readAllLinesFromFile() throws IOException {
    return Files.readAllLines(Paths.get("liczby.txt"));
  }


  private static String[] splitBySpace(String s) {
    return s.split(" ");
  }
}
