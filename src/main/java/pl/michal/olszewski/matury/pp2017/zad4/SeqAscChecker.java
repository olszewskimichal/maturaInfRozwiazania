package pl.michal.olszewski.matury.pp2017.zad4;

class SeqAscChecker {

  private static boolean isValid(Integer first, Integer second, Integer third) {
    return first < second && second < third;
  }

  /**
   * Określa czy liczby w trójce są uporządkowane rosnąco
   */
  static boolean isValid(String first, String second, String third) {
    return isValid(Integer.valueOf(first), Integer.valueOf(second), Integer.valueOf(third));
  }

}
