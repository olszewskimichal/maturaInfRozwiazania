package pl.michal.olszewski.matury.pr2017nowa.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArrayNeighborsOfPointTest {

  int[][] multi = new int[][]{
      {1, 2, 3, 4, 5},
      {6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15},
      {16, 17, 18, 19, 20},
      {21, 22, 23, 24, 25},
  };

  @Test
  void shouldFind3NeigborsOfPointForCorners() {
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(0, 0, multi)).hasSize(3);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 0, multi)).hasSize(3);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 0, multi)).hasSize(3);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 4, multi)).hasSize(3);
  }

  @Test
  void shouldFind5NeigborsOfPointForFirstAndLastRowInTheMiddle() {
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(0, 1, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(0, 2, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(0, 3, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 1, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 2, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(4, 3, multi)).hasSize(5);
  }

  @Test
  void shouldFind5NeigborsOfPointForFirstAndLastColumnInTheMiddle() {
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(1, 0, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(2, 0, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(3, 0, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(1, 4, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(2, 4, multi)).hasSize(5);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(3, 4, multi)).hasSize(5);
  }

  @Test
  void shouldFind8NeigborsOfPoint() {
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(1, 1, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(2, 1, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(3, 1, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(1, 2, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(2, 2, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(3, 2, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(1, 3, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(2, 3, multi)).hasSize(8);
    assertThat(ArrayNeighborsOfPoint.findNeighborsOfPoint(3, 3, multi)).hasSize(8);
  }
}