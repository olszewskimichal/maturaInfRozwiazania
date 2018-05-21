package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SplitLineToWycieczkaPOJO {

  public static Wycieczka split(String line) {
    String[] split = line.split("\t");
    return new Wycieczka(Long.valueOf(split[0]), split[1], split[2], split[3], LocalDate.parse(split[4]), LocalDate.parse(split[5]), new BigDecimal(split[6]));
  }

}
