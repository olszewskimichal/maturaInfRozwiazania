package pl.michal.olszewski.matury.pp2017.zad5;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SplitLineToWynajemPOJO {

  public static Wynajem split(String line) {
    String[] split = line.split("\t");
    return new Wynajem(
        LocalDate.parse(split[0]),
        LocalDate.parse(split[1]),
        new BigDecimal(split[2].replaceAll(",", ".")),
        new BigDecimal(split[3].replaceAll(",", ".")),
        Long.valueOf(split[4]));
  }

}
