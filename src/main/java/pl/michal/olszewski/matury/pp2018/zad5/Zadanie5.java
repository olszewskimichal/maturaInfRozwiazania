package pl.michal.olszewski.matury.pp2018.zad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Zadanie5 {

  public static void main(String[] args) throws IOException {
    System.out.println("zad 5.1");
    Files.readAllLines(Paths.get("liczby.txt"))
        .stream().map(Long::valueOf)
        .filter(v -> v % 2 == 0)
        .max(Long::compare)
        .ifPresent(System.out::println);

    System.out.println("zad 5.2");
    Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .filter(Zadanie5::isPalindromeUsingIntStream)
        .forEach(System.out::println);

    System.out.println("zad 5.3a");
    Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .filter(v -> digitSum(v) > 30).
        forEach(System.out::println);

    System.out.println("zad 5.3b");
    System.out.println(Files.readAllLines(Paths.get("liczby.txt"))
        .stream()
        .mapToLong(Zadanie5::digitSum)
        .sum());

  }


  private static boolean isPalindromeUsingIntStream(String text) {
    String temp = text.replaceAll("\\s+", "").toLowerCase();
    return IntStream.range(0, temp.length() / 2)
        .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
  }

  private static long digitSum(String text) {
    return String.valueOf(text)
        .chars()
        .map(Character::getNumericValue)
        .sum();
  }


}
