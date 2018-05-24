package pl.michal.olszewski.matury.pr2017nowa.zad5;

public class SplitLineToRefereePOJO {

  public static Referee split(String line) {
    String[] split = line.split("\t");
    return new Referee(
        split[0]
    );
  }

}
