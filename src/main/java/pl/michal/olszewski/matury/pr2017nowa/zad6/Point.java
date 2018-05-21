package pl.michal.olszewski.matury.pr2017nowa.zad6;

public class Point {

  final int x;
  final int y;
  final int value;

  public Point(int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getValue() {
    return value;
  }

  public boolean isKontrastujacy(Point anotherPoint) {
    //System.out.println(getValue() + " " + anotherPoint.getValue());
    return isOnTheSameRowOrTheSameColumn(anotherPoint) && Math.abs(getValue() - anotherPoint.getValue()) > 128;
  }

  private boolean isOnTheSameRowOrTheSameColumn(Point anotherPoint) {
    return (getX() == anotherPoint.getX() || getY() == anotherPoint.getY());
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        ", value=" + value +
        '}';
  }
}
