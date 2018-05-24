package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.time.LocalDate;

class MatchResult {

  private final LocalDate matchDate;
  private final MatchType matchType;
  private final MatchPlace matchPlace;
  private final long teamId;
  private final String licenceNum;
  private final int bramkiZdobyte;
  private final int bramkiStracone;

  MatchResult(LocalDate matchDate, MatchType matchType, MatchPlace matchPlace, long teamId, String licenceNum, int bramkiZdobyte, int bramkiStracone) {
    this.matchDate = matchDate;
    this.matchType = matchType;
    this.matchPlace = matchPlace;
    this.teamId = teamId;
    this.licenceNum = licenceNum;
    this.bramkiZdobyte = bramkiZdobyte;
    this.bramkiStracone = bramkiStracone;
  }

  LocalDate getMatchDate() {
    return matchDate;
  }

  MatchType getMatchType() {
    return matchType;
  }

  MatchPlace getMatchPlace() {
    return matchPlace;
  }

  long getTeamId() {
    return teamId;
  }

  String getLicenceNum() {
    return licenceNum;
  }

  int getBramkiZdobyte() {
    return bramkiZdobyte;
  }

  int getBramkiStracone() {
    return bramkiStracone;
  }
}

