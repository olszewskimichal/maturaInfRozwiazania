package pl.michal.olszewski.matury.pr2017nowa.zad4;

import java.time.LocalDate;

public class SplitLineToSugarTransaction {

  public static SugarTransaction split(String line) {
    String[] split = line.split("\t");
    return new SugarTransaction(LocalDate.parse(split[0]), split[1], Integer.valueOf(split[2]));
  }

}
