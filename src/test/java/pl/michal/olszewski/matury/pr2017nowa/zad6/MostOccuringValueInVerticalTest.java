package pl.michal.olszewski.matury.pr2017nowa.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MostOccuringValueInVerticalTest {

  int[][] multi = new int[][]{
      {6, 2, 3, 4, 5},
      {6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15},
      {16, 17, 18, 19, 20},
      {21, 22, 23, 24, 25},
  };

  int[][] multi2 = new int[][]{
      {1, 2, 3, 4, 5},
      {6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15},
      {16, 17, 13, 19, 20},
      {21, 22, 23, 24, 25},
  };

  int[][] multi3 = new int[][]{
      {1, 2, 3},
      {6, 7, 8},
      {11, 12, 13},
      {16, 17, 13},
      {21, 22, 23},
  };

  int[][] multi4 = new int[][]{
      {1, 2, 3},
      {6, 7, 8, 9},
      {11, 12, 13, 1, 10},
      {16, 17, 13, 1},
      {21, 22, 23, 2, 3, 4},
  };

  @Test
  void findValue() {
    assertThat(MostOccuringValueInVertical.findValue(multi)).isEqualTo(2);
  }

  @Test
  void findValue2() {
    assertThat(MostOccuringValueInVertical.findValue(multi2)).isEqualTo(2);
  }

  @Test
  void findValue3() {
    assertThat(MostOccuringValueInVertical.findValue(multi3)).isEqualTo(2);
  }

  @Test
  void findValue4() {
    assertThat(MostOccuringValueInVertical.findValue(multi4)).isEqualTo(2);
  }

  @Test
  void findMostOccuringValueInArray() {
    int[] array = new int[]{1, 2, 2, 2, 1, 1};
    MostOccurringNextValue valueInArray = MostOccuringValueInVertical.findMostOccuringValueInArray(array);
    assertThat(valueInArray.getValue()).isEqualTo(2);
    assertThat(valueInArray.getOccurring()).isEqualTo(3);
  }
}