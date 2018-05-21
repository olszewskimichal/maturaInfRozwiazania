package pl.michal.olszewski.matury.pr2017nowa.zad5;

public class SplitLineToRefreePOJO {

  public static Refree split(String line) {
    String[] split = line.split("\t");
    return new Refree(split[0], split[1], split[2]);
  }

}
