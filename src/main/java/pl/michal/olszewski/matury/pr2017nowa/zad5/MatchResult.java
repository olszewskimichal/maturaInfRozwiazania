package pl.michal.olszewski.matury.pr2017nowa.zad5;

import java.time.LocalDate;

public class MatchResult {

  private final LocalDate matchDate;
  private final MatchType matchType;
  private final MatchPlace matchPlace;
  private final long teamId;
  private final String licenceNum;
  private final int bramkiZdobyte;
  private final int bramkiStracone;

  public MatchResult(LocalDate matchDate, MatchType matchType, MatchPlace matchPlace, long teamId, String licenceNum, int bramkiZdobyte, int bramkiStracone) {
    this.matchDate = matchDate;
    this.matchType = matchType;
    this.matchPlace = matchPlace;
    this.teamId = teamId;
    this.licenceNum = licenceNum;
    this.bramkiZdobyte = bramkiZdobyte;
    this.bramkiStracone = bramkiStracone;
  }

  public LocalDate getMatchDate() {
    return matchDate;
  }

  public MatchType getMatchType() {
    return matchType;
  }

  public MatchPlace getMatchPlace() {
    return matchPlace;
  }

  public long getTeamId() {
    return teamId;
  }

  public String getLicenceNum() {
    return licenceNum;
  }

  public int getBramkiZdobyte() {
    return bramkiZdobyte;
  }

  public int getBramkiStracone() {
    return bramkiStracone;
  }
}

