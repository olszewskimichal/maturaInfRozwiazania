package pl.michal.olszewski.matury.pp2017.zad4;

public class SeqAscChecker {

  private static boolean isValid(Integer first, Integer second, Integer third) {
    return first < second && second < third;
  }

  public static boolean isValid(String first, String second, String third) {
    return isValid(Integer.valueOf(first), Integer.valueOf(second), Integer.valueOf(third));
  }

}
