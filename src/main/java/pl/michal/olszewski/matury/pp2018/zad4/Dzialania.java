package pl.michal.olszewski.matury.pp2018.zad4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dzialania {

  private final String harcerzId;
  private final LocalDate from;
  private final LocalDate to;
  private final String sprawnoscId;
  private final Integer points;
  private Sprawnosc sprawnosc;

  Dzialania(String harcerzId, LocalDate from, LocalDate to, String sprawnoscId, Integer points) {
    this.harcerzId = harcerzId;
    this.from = from;
    this.to = to;
    this.sprawnoscId = sprawnoscId;
    this.points = points;
  }

  String getHarcerzId() {
    return harcerzId;
  }

  LocalDate getFrom() {
    return from;
  }

  LocalDate getTo() {
    return to;
  }

  String getSprawnoscId() {
    return sprawnoscId;
  }

  Integer getPoints() {
    return points;
  }

  Sprawnosc getSprawnosc() {
    return sprawnosc;
  }

  void setSprawnosc(Sprawnosc sprawnosc) {
    this.sprawnosc = sprawnosc;
  }
  
  Long days() {
    return ChronoUnit.DAYS.between(getFrom(), getTo()) + 1L;
  }

}
