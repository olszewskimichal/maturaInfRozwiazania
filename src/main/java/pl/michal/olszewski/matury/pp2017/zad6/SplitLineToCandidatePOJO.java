package pl.michal.olszewski.matury.pp2017.zad6;

public class SplitLineToCandidatePOJO {

  public static Candidate split(String line) {
    String[] split = line.split("\t");
    return new Candidate(
        Long.valueOf(split[0]),
        split[1],
        split[2]);
  }

}
