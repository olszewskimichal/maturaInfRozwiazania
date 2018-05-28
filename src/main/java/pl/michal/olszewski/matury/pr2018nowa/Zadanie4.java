package pl.michal.olszewski.matury.pr2018nowa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Zadanie4 {

  public static void main(String[] args) throws IOException {
    System.out.println("zad 4.1 ");
    List<String> allLines = Files.readAllLines(Paths.get("sygnaly.txt"));

    StringBuilder result = new StringBuilder();
    for (int i = 1; i <= allLines.size(); i++) {
      if (i % 40 == 0) {
        String string = allLines.get(i - 1);
        result.append(string.charAt(9));
      }
    }
    System.out.println(result);

    System.out.println("zad 4.2 ");

    int max = 0;
    String result42 = "";
    for (String line : allLines) {
      Set<Character> charsSet = line.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
      if (charsSet.size() > max) {
        max = charsSet.size();
        result42 = line;
      }
    }
    System.out.println(result42);

    System.out.println(isFar10Character("CGECF"));
    System.out.println(isFar10Character("ABEZA"));

    System.out.println("zad 4.3 ");

    allLines
        .stream()
        .filter(Zadanie4::isFar10Character)
        .forEach(System.out::println);
  }

  private static boolean isFar10Character(String line) {
    for (int i = 0; i < line.toCharArray().length - 1; i++) {
      int c1 = line.toCharArray()[i];
      int c2 = line.toCharArray()[i + 1];
      if (Math.abs(c2 - c1) > 10) {
        return false;
      }
    }
    return true;
  }


}
