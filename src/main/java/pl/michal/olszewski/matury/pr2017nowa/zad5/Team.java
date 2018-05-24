package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.util.ArrayList;
import java.util.List;

class Team {

  private final Long id;
  private final String name;
  private final String city;
  private List<MatchResult> resultList = new ArrayList<>();

  Team(Long id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  Long getId() {
    return id;
  }

  String getName() {
    return name;
  }

  String getCity() {
    return city;
  }

  List<MatchResult> getResultList() {
    return resultList;
  }
}
