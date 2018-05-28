package pl.michal.olszewski.matury.pp2018.zad4;

import java.util.ArrayList;
import java.util.List;

public class Harcerz {

  private final String id;
  private final String name;
  private final String lastName;
  private final String team;
  private List<Dzialania> dzialania = new ArrayList<>();

  Harcerz(String id, String name, String lastName, String team) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.team = team;
  }

  String getId() {
    return id;
  }

  String getName() {
    return name;
  }

  String getLastName() {
    return lastName;
  }

  String getTeam() {
    return team;
  }

  List<Dzialania> getDzialania() {
    return dzialania;
  }

  Long ileSprawnosci() {
    return dzialania.stream()
        .map(Dzialania::getSprawnoscId)
        .distinct()
        .count();
  }

  Dzialania getMaxSprawnoscDays() {
    Long max = 0L;
    Dzialania tmp = null;
    for (Dzialania dzialanie : dzialania) {
      if (dzialanie.days() > max) {
        max = dzialanie.days();
        tmp = dzialanie;
      }
    }
    return tmp;
  }
}
