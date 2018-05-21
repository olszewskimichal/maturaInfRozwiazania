package pl.michal.olszewski.matury.pr2017nowa.zad5;

public class SplitLineToTeamPOJO {

  public static Team split(String line) {
    String[] split = line.split("\t");
    return new Team(Long.valueOf(split[0]), split[1], split[2]);
  }

}
