package pl.michal.olszewski.matury.pr2018stara;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Predicate;

public class Zadanie6 {

  public static void main(String[] args) throws IOException {
    System.out.println("zad 6.1 " + Files.readAllLines(Paths.get("slowa.txt"))
        .stream()
        .flatMap(v -> Arrays.stream(v.split(" ")))
        .filter(v -> v.endsWith("A"))
        .count());

    System.out.println("zad 6.2 " + Files.readAllLines(Paths.get("slowa.txt"))
        .stream()
        .filter(filterContainingTheSame())
        .count());

    System.out.println("zad 6.3 " + Files.readAllLines(Paths.get("slowa.txt"))
        .stream()
        .filter(filterAnagram())
        .count());
    Files.readAllLines(Paths.get("slowa.txt"))
        .stream()
        .filter(filterAnagram())
        .forEach(System.out::println);

  }

  private static Predicate<? super String> filterContainingTheSame() {
    return v -> {
      String[] split = v.split(" ");
      return split[1].contains(split[0]);
    };
  }

  private static Predicate<? super String> filterAnagram() {
    return v -> {
      String[] split = v.split(" ");
      char[] word1 = split[0].toCharArray();
      char[] word2 = split[1].toCharArray();

      Arrays.sort(word1);
      Arrays.sort(word2);
      return Arrays.equals(word1, word2);
    };
  }

}
