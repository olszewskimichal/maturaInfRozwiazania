package pl.michal.olszewski.matury.pr2017stara.zad6;

public class SplitLineToPersonPOJO {

  public static Person split(String line) {
    String[] split = line.split("\t");
    return new Person(
        Long.valueOf(split[0]),
        split[1],
        split[2]);
  }

}
