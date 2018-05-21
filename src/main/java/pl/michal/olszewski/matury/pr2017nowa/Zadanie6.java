package pl.michal.olszewski.matury.pr2017nowa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pl.michal.olszewski.matury.pr2017nowa.zad6.ArrayNeigborsOfPoint;
import pl.michal.olszewski.matury.pr2017nowa.zad6.FindRowAxisOfSymmetry;
import pl.michal.olszewski.matury.pr2017nowa.zad6.MostOccuringValueInVertical;
import pl.michal.olszewski.matury.pr2017nowa.zad6.Point;

public class Zadanie6 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 6.1");
    IntSummaryStatistics statistics = readLinesFromFiles().parallelStream()
        .map(v -> v.split(" "))
        .flatMap(Stream::of)
        .map(Integer::valueOf)
        .collect(Collectors.summarizingInt(v -> v));
    System.out.println("Max " + statistics.getMax() + " Min " + statistics.getMin());

    int[][] array = readArrayFromFile();

    System.out.println("Zad 6.2 wynik = " + FindRowAxisOfSymmetry.find(array));

    int countPixels = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        //System.out.println(" i = " + i + " j = " + j + " " + array.length + " " + array[i].length);
        Point point = new Point(i, j, array[i][j]);
        Optional<Point> any = ArrayNeigborsOfPoint.findNeigborsOfPoint(i, j, array)
            .stream()
            .filter(v -> v.isKontrastujacy(point))
            .findAny();
        if (any.isPresent()) {
          countPixels++;
        }

      }
    }
    System.out.println("Zad 6.3  wynik = " + countPixels);
    System.out.println("Zad 6.4 wynik = " + MostOccuringValueInVertical.findValue(array));


  }


  private static List<String> readLinesFromFiles() throws IOException {
    return new ArrayList<>(Files.readAllLines(Paths.get("dane.txt")));
  }

  private static int[][] readArrayFromFile() throws IOException {
    return Files.readAllLines(Paths.get("dane.txt"))
        .stream()
        .map(Zadanie6::splitLine)
        .toArray(int[][]::new);
  }

  private static int[] splitLine(String item) {
    return Stream.of(item.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
