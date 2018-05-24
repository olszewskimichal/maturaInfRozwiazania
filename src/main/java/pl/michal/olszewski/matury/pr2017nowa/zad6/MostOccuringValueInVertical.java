package pl.michal.olszewski.matury.pr2017nowa.zad6;

import java.util.Arrays;

class MostOccuringValueInVertical {

  private static int[] getColumn(int[][] matrix, int column) {
    return Arrays.stream(matrix).mapToInt(ints -> ints[column]).toArray();
  }

  static MostOccurringNextValue findMostOccuringValueInArray(int[] array) {
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
    return new MostOccurringNextValue(resultValue, resultOccuring);
  }

  static int findValue(int[][] array) {
    int maxOccur = 0;

    int width = findNajkrotszyWiersz(array);
    for (int i = 0; i < width; i++) {

      int[] columnValues = getColumn(array, i);
      MostOccurringNextValue occuringNextValue = findMostOccuringValueInArray(columnValues);

      if (occuringNextValue.getOccurring() > maxOccur) {
        maxOccur = occuringNextValue.getOccurring();
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

class MostOccurringNextValue {

  private final int value;
  private final int occurring;

  MostOccurringNextValue(int value, int occurring) {
    this.value = value;
    this.occurring = occurring;
  }

  int getValue() {
    return value;
  }

  int getOccurring() {
    return occurring;
  }

}
