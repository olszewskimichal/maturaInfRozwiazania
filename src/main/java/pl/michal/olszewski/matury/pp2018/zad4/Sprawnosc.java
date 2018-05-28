package pl.michal.olszewski.matury.pp2018.zad4;

import java.util.ArrayList;
import java.util.List;

class Sprawnosc {

  private final String id;
  private final String name;
  private List<Dzialania> dzialania = new ArrayList<>();

  Sprawnosc(String id, String name) {
    this.id = id;
    this.name = name;
  }

  String getId() {
    return id;
  }

  String getName() {
    return name;
  }

  List<Dzialania> getDzialania() {
    return dzialania;
  }

  Integer getPointsSum() {
    return dzialania
        .stream()
        .mapToInt(Dzialania::getPoints)
        .sum();
  }

}
