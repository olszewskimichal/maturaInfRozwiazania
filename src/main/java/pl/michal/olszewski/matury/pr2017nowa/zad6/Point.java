package pl.michal.olszewski.matury.pr2017nowa.zad6;

public class Point {

  private final int x;
  private final int y;
  private final int value;

  Point(int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;
  }

  private int getX() {
    return x;
  }

  private int getY() {
    return y;
  }

  private int getValue() {
    return value;
  }

  boolean isKontrastujacy(Point anotherPoint) {
    return isOnTheSameRowOrTheSameColumn(anotherPoint) && Math.abs(getValue() - anotherPoint.getValue()) > 128;
  }

  private boolean isOnTheSameRowOrTheSameColumn(Point anotherPoint) {
    return (getX() == anotherPoint.getX() || getY() == anotherPoint.getY());
  }

}
