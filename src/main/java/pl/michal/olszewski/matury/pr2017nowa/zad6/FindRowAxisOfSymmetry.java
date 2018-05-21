package pl.michal.olszewski.matury.pr2017nowa.zad6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindRowAxisOfSymmetry {

  public static long find(int[][] array) {
    return Arrays.stream(array)
        .filter(anArray -> IntStream.range(0, anArray.length / 2)
            .anyMatch(j -> anArray[j] != anArray[anArray.length - j - 1]))
        .count();
  }
}
