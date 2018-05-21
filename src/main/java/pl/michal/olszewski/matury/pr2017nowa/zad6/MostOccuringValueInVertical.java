package pl.michal.olszewski.matury.pr2017nowa.zad6;

import java.util.Arrays;

public class MostOccuringValueInVertical {

  private static int[] getColumn(int[][] matrix, int column) {
    return Arrays.stream(matrix).mapToInt(ints -> ints[column]).toArray();
  }

  static MostOccuringNextValue findMostOccuringValueInArray(int[] array) {
    Integer resultValue = 0;
    int resultOccuring = 0;

    Integer maxValue = null;
    int occuring = 0;
    for (int value : array) {
      if (maxValue == null) {
        maxValue = value;
        occuring++;
      } else if (maxValue == value) {
        occuring++;
      } else {
        maxValue = value;
        occuring = 1;
      }

      if (occuring > resultOccuring) {
        resultValue = maxValue;
        resultOccuring = occuring;
      }
    }
    return new MostOccuringNextValue(resultValue, resultOccuring);
  }

  public static int findValue(int[][] array) {
    int maxOccur = 0;

    int width = findNajkrotszyWiersz(array);
    for (int i = 0; i < width; i++) {

      int[] columnValues = getColumn(array, i);
      MostOccuringNextValue occuringNextValue = findMostOccuringValueInArray(columnValues);

      if (occuringNextValue.getOccuring() > maxOccur) {
        maxOccur = occuringNextValue.getOccuring();
      }
    }

    return maxOccur;
  }

  private static int findNajkrotszyWiersz(int[][] array) {
    int min = array[0].length;
    for (int[] anArray : array) {
      if (min > anArray.length) {
        min = anArray.length;
      }
    }
    return min;
  }


}

class MostOccuringNextValue {

  private final int value;
  private final int occuring;

  MostOccuringNextValue(int value, int occuring) {
    this.value = value;
    this.occuring = occuring;
  }

  public int getValue() {
    return value;
  }

  public int getOccuring() {
    return occuring;
  }

  @Override
  public String toString() {
    return "MostOccuringNextValue{" +
        "value=" + value +
        ", occuring=" + occuring +
        '}';
  }
}
