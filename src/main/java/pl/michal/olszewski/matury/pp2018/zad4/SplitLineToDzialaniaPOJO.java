package pl.michal.olszewski.matury.pp2018.zad4;

import java.time.LocalDate;

public class SplitLineToDzialaniaPOJO {

  public static Dzialania split(String line) {
    String[] split = line.split(";");
    return new Dzialania(
        split[0],
        LocalDate.parse(split[1]),
        LocalDate.parse(split[2]),
        split[3],
        Integer.valueOf(split[4]));
  }
}
