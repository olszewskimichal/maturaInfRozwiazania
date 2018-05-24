package pl.michal.olszewski.matury.pp2017.zad5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Rent {

  private final LocalDate from;
  private final LocalDate to;
  private final BigDecimal energy;
  private final BigDecimal water;
  private final Long type;

  Rent(LocalDate from, LocalDate to, BigDecimal energy, BigDecimal water, Long type) {
    this.from = from;
    this.to = to;
    this.energy = energy;
    this.water = water;
    this.type = type;
  }

  LocalDate getFrom() {
    return from;
  }

  LocalDate getTo() {
    return to;
  }

  BigDecimal getEnergy() {
    return energy;
  }

  BigDecimal getWater() {
    return water;
  }

  Long getType() {
    return type;
  }

  BigDecimal getCostSum() {
    long days = ChronoUnit.DAYS.between(getFrom(), getTo());
    return BigDecimal.TEN.multiply(BigDecimal.valueOf(type)).multiply(BigDecimal.valueOf(days)).add(getEnergy()).add(getWater());
  }
}
