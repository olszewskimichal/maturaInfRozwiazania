package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.util.ArrayList;
import java.util.List;

public class Team {

  private final Long id;
  private final String name;
  private final String city;
  private List<MatchResult> resultList = new ArrayList<>();

  public Team(Long id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public List<MatchResult> getResultList() {
    return resultList;
  }
}
