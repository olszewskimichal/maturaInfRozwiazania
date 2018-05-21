package pl.michal.olszewski.matury.pr2017stara;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pr2017stara.zad4.BCDChecker;
import pl.michal.olszewski.matury.pr2017stara.zad4.TwoCyclingChecker;

public class Zadanie4 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 4.1");
    List<String> twoCyclingList = getAllTwoCyclingString();
    System.out.println("Liczba napisów dwucyklicznych " + twoCyclingList.size());
    twoCyclingList.stream()
        .max(Comparator.comparingInt(String::length))
        .ifPresent(v -> System.out.println("Najdluzsze dwycykliczne slowo to " + v));
    System.out.println("Zad 4.2");

    List<String> incorrectBCD = readLinesFromFiles().parallelStream()
        .filter(v -> !BCDChecker.check(v))
        .collect(Collectors.toList());
    System.out.println("Niepoprawnych napisow " + incorrectBCD.size());

    incorrectBCD.parallelStream().min(Comparator.comparingInt(String::length))
        .ifPresent(v -> System.out.println("Najkrotszy wyraz ma dlugosc " + v.length()));

    System.out.println("Zad 4.3");
    readLinesFromFiles().stream()
        .filter(v -> v.length() <= 16)
        .max(Comparator.comparingInt(e -> Integer.parseInt(e, 2)))
        .ifPresent(v -> System.out.println("Najwieksza liczba binarna to " + v + " co jest rowne " + Integer.parseInt(v, 2)));

  }

  private static List<String> getAllTwoCyclingString() throws IOException {
    return readLinesFromFiles()
        .stream()
        .filter(TwoCyclingChecker::check)
        .collect(Collectors.toList());
  }

  private static List<String> readLinesFromFiles() throws IOException {
    return new ArrayList<>(Files.readAllLines(Paths.get("binarne.txt")));
  }
}
