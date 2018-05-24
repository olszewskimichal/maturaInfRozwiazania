package pl.michal.olszewski.matury.pr2017stara.zad4;

class TwoCyclingChecker {

  static boolean check(String line) {
    String a = line.substring(0, line.length() / 2);
    String b = line.substring(line.length() / 2);
    return a.equals(b);
  }

}
