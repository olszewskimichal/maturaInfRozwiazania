package pl.michal.olszewski.matury.pr2017nowa.zad6;

import java.util.ArrayList;
import java.util.List;

class ArrayNeighborsOfPoint {

  static List<Point> findNeighborsOfPoint(int xpoint, int ypoint, int[][] array) {
    List<Point> neighbors = new ArrayList<>();
    for (int x = -1; x <= 1; x++) {
      for (int y = -1; y <= 1; y++) {
        if (x == 0 && y == 0) {
          continue; // You are not neighbor to yourself
        }

        if (isOnMap(x + xpoint, y + ypoint, array)) {
          neighbors.add(new Point(x + xpoint, y + ypoint, array[x + xpoint][y + ypoint]));
        }

      }
    }
    return neighbors;
  }

  private static boolean isOnMap(int x, int y, int[][] array) {
    return x >= 0 && y >= 0 && x < array.length && y < array[x].length;
  }

}
