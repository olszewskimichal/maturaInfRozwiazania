package pl.michal.olszewski.matury.pp2017.zad4;

class GreatestCommonDivisor {


  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  static int calculate(int a, int b, int c) {
    return gcd(gcd(a, b), c);
  }


  /**
   *  Wyznacza najwiekszy wspólny dzielnik z trójki liczb bedących Stringami
   */
  static int calculate(String a, String b, String c) {
    return calculate(Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c));
  }

}
