package pl.michal.olszewski.matury.pr2017stara.zad4;

import java.util.ArrayList;
import java.util.List;

class BCDChecker {

  static boolean check(String line) {
    return splitForEvery4Bit(line)
        .stream()
        .map(v -> Integer.parseInt(v, 2))
        .allMatch(v -> v <= 9);
  }

  private static List<String> splitForEvery4Bit(String line) {
    List<String> strings = new ArrayList<>();
    int index = 0;
    while (index < line.length()) {
      strings.add(line.substring(index, Math.min(index + 4, line.length())));
      index += 4;
    }
    return strings;
  }

}
