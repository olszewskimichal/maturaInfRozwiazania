package pl.michal.olszewski.matury.pp2017.zad6;

public class SplitLineToGlosPOJO {

  public static Glos split(String line) {
    String[] split = line.split("\t");
    return new Glos(Long.valueOf(split[0]), Long.valueOf(split[1]), Long.valueOf(split[2]));
  }

}
