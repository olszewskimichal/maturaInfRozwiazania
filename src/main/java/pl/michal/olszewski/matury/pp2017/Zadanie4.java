package pl.michal.olszewski.matury.pp2017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import pl.michal.olszewski.matury.pp2017.zad4.DigitSumCalculator;
import pl.michal.olszewski.matury.pp2017.zad4.GreatestCommonDivisor;
import pl.michal.olszewski.matury.pp2017.zad4.SeqAscChecker;

public class Zadanie4 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 4 - Matura 2017");
    long count = Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .map(Zadanie4::splitBySpace)
        .filter(s -> SeqAscChecker.isValid(s[0], s[1], s[2]))
        .count();
    System.out.println("Wynik 4a to " + count);

    long sum = Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .map(Zadanie4::splitBySpace)
        .map(s -> GreatestCommonDivisor.calculate(s[0], s[1], s[2]))
        .mapToInt(v -> v)
        .sum();
    System.out.println("Wynik 4b to " + sum);

    long count2 = Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .map(Zadanie4::splitBySpace)
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .filter(v -> v.equals(35))
        .count();
    System.out.println("Wynik 4c to " + count2);

    Integer maxValue = Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .map(Zadanie4::splitBySpace)
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .max(Integer::compareTo)
        .orElse(0);

    long count3 = Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .map(Zadanie4::splitBySpace)
        .map(s -> DigitSumCalculator.calculate(s[0], s[1], s[2]))
        .filter(v -> v.equals(maxValue))
        .count();
    System.out.println("Wynik 4c -> Maksymalna wartosc to " + maxValue + " która wystapila " + count3);



  }


  private static String[] splitBySpace(String s) {
    return s.split(" ");
  }
}
