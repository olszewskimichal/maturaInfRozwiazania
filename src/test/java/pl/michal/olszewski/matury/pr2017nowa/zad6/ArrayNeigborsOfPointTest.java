package pl.michal.olszewski.matury.pr2017nowa.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArrayNeigborsOfPointTest {

  int[][] multi = new int[][]{
      {1, 2, 3, 4, 5},
      {6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15},
      {16, 17, 18, 19, 20},
      {21, 22, 23, 24, 25},
  };

  @Test
  void shouldFind3NeigborsOfPointForCorners() {
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(0, 0, multi)).hasSize(3);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 0, multi)).hasSize(3);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 0, multi)).hasSize(3);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 4, multi)).hasSize(3);
  }

  @Test
  void shouldFind5NeigborsOfPointForFirstAndLastRowInTheMiddle() {
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(0, 1, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(0, 2, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(0, 3, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 1, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 2, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(4, 3, multi)).hasSize(5);
  }

  @Test
  void shouldFind5NeigborsOfPointForFirstAndLastColumnInTheMiddle() {
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(1, 0, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(2, 0, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(3, 0, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(1, 4, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(2, 4, multi)).hasSize(5);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(3, 4, multi)).hasSize(5);
  }

  @Test
  void shouldFind8NeigborsOfPoint() {
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(1, 1, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(2, 1, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(3, 1, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(1, 2, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(2, 2, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(3, 2, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(1, 3, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(2, 3, multi)).hasSize(8);
    assertThat(ArrayNeigborsOfPoint.findNeigborsOfPoint(3, 3, multi)).hasSize(8);
  }
}