package pl.michal.olszewski.matury.pp2018.zad6;

import java.time.LocalDate;

public class SplitLineToMakulatura {

  public static Makulatura split(String line) {
    String[] split = line.split("\t");
    return new Makulatura(
        LocalDate.parse(split[0]),
        split[1],
        split[2],
        Integer.valueOf(split[3]));
  }
}
