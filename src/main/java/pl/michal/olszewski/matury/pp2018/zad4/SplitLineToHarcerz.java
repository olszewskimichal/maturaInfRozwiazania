package pl.michal.olszewski.matury.pp2018.zad4;

public class SplitLineToHarcerz {

  public static Harcerz split(String line) {
    String[] split = line.split(";");
    return new Harcerz(
        split[0],
        split[1],
        split[2],
        split[3]);
  }
}
