package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.time.LocalDate;

public class SplitLineToMatchResultPOJO {

  public static MatchResult split(String line) {
    String[] split = line.split("\t");
    return new MatchResult(
        LocalDate.parse(split[0]),
        MatchType.valueOf(split[1]),
        MatchPlace.valueOf(split[2]),
        Long.valueOf(split[3]),
        split[4],
        Integer.valueOf(split[5]),
        Integer.valueOf(split[6]));
  }

}
