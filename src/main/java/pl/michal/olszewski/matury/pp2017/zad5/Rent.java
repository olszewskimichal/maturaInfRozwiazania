package pl.michal.olszewski.matury.pp2017.zad5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rent {

  private final LocalDate from;
  private final LocalDate to;
  private final BigDecimal energy;
  private final BigDecimal water;
  private final Long type;

  public Rent(LocalDate from, LocalDate to, BigDecimal energy, BigDecimal water, Long type) {
    this.from = from;
    this.to = to;
    this.energy = energy;
    this.water = water;
    this.type = type;
  }

  public LocalDate getFrom() {
    return from;
  }

  public LocalDate getTo() {
    return to;
  }

  public BigDecimal getEnergy() {
    return energy;
  }

  public BigDecimal getWater() {
    return water;
  }

  public Long getType() {
    return type;
  }

  public BigDecimal sumaWydatkow() {
    long days = ChronoUnit.DAYS.between(getFrom(), getTo());
    return BigDecimal.TEN.multiply(BigDecimal.valueOf(type)).multiply(BigDecimal.valueOf(days)).add(getEnergy()).add(getWater());
  }
}
