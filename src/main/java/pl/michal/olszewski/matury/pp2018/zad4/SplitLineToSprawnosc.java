package pl.michal.olszewski.matury.pp2018.zad4;

public class SplitLineToSprawnosc {

  public static Sprawnosc split(String line) {
    String[] split = line.split(";");
    return new Sprawnosc(
        split[0],
        split[1]);
  }
}
