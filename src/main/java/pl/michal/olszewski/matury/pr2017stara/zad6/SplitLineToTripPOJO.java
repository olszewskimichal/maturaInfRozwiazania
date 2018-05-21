package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SplitLineToTripPOJO {

  public static Trip split(String line) {
    String[] split = line.split("\t");
    return new Trip(
        Long.valueOf(split[0]),
        split[1],
        split[3],
        LocalDate.parse(split[4]),
        new BigDecimal(split[6]));
  }

}
