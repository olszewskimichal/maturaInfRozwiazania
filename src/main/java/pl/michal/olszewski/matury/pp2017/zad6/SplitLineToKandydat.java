package pl.michal.olszewski.matury.pp2017.zad6;

public class SplitLineToKandydat {

  public static Kandydat split(String line) {
    String[] split = line.split("\t");
    return new Kandydat(Long.valueOf(split[0]), split[1], split[2]);
  }

}
