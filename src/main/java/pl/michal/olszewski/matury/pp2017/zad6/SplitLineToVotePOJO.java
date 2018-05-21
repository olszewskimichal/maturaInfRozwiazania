package pl.michal.olszewski.matury.pp2017.zad6;

public class SplitLineToVotePOJO {

  public static Vote split(String line) {
    String[] split = line.split("\t");
    return new Vote(
        Long.valueOf(split[0]),
        Long.valueOf(split[1]),
        Long.valueOf(split[2]));
  }

}
