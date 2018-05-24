package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.util.ArrayList;
import java.util.List;

class Referee {

  private final String licenceNum;
  private List<MatchResult> matchResults = new ArrayList<>();

  Referee(String licenceNum) {
    this.licenceNum = licenceNum;
  }

  String getLicenceNum() {
    return licenceNum;
  }

  List<MatchResult> getMatchResults() {
    return matchResults;
  }
}
