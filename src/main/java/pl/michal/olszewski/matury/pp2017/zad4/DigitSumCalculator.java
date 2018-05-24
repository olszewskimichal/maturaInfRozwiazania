package pl.michal.olszewski.matury.pp2017.zad4;

class DigitSumCalculator {

  static int calculate(String num) {
    return num.chars()
        .map(Character::getNumericValue)
        .sum();
  }

  static int calculate(String a, String b, String c) {
    return calculate(a) + calculate(b) + calculate(c);
  }

}
