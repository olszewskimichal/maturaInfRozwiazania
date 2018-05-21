package pl.michal.olszewski.matury.pr2017stara.zad6;

public class SplitStringToOsoba {

  public static Osoba split(String line) {
    String[] split = line.split("\t");
    return new Osoba(Long.valueOf(split[0]), split[1], split[2]);
  }

}
