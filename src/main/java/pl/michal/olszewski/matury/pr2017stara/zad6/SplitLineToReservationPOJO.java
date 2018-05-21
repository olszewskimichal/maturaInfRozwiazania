package pl.michal.olszewski.matury.pr2017stara.zad6;

public class SplitLineToReservationPOJO {

  public static Reservation split(String line) {
    String[] split = line.split("\t");
    return new Reservation(
        Long.valueOf(split[0]),
        Long.valueOf(split[1]),
        Long.valueOf(split[2]),
        Integer.valueOf(split[3]),
        Integer.valueOf(split[4]));
  }

}
