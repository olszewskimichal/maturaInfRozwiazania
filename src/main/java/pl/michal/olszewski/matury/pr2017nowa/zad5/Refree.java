package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.util.ArrayList;
import java.util.List;

public class Refree {

  private final String licenceNum;
  private final String name;
  private final String lastName;
  private List<MatchResult> matchResults = new ArrayList<>();

  public Refree(String licenceNum, String name, String lastName) {
    this.licenceNum = licenceNum;
    this.name = name;
    this.lastName = lastName;
  }

  public String getLicenceNum() {
    return licenceNum;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public List<MatchResult> getMatchResults() {
    return matchResults;
  }
}
