package pl.michal.olszewski.matury.pp2017.zad5;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wynajem {

  private final LocalDate dataPrzyjazdu;
  private final LocalDate dataWyjazdu;
  private final BigDecimal energia;
  private final BigDecimal woda;
  private final Long typ;

  public Wynajem(LocalDate dataPrzyjazdu, LocalDate dataWyjazdu, BigDecimal energia, BigDecimal woda, Long typ) {
    this.dataPrzyjazdu = dataPrzyjazdu;
    this.dataWyjazdu = dataWyjazdu;
    this.energia = energia;
    this.woda = woda;
    this.typ = typ;
  }

  public LocalDate getDataPrzyjazdu() {
    return dataPrzyjazdu;
  }

  public LocalDate getDataWyjazdu() {
    return dataWyjazdu;
  }

  public BigDecimal getEnergia() {
    return energia;
  }

  public BigDecimal getWoda() {
    return woda;
  }

  public Long getTyp() {
    return typ;
  }

  public BigDecimal sumaWydatkow() {
    long days = ChronoUnit.DAYS.between(getDataPrzyjazdu(), getDataWyjazdu());
    return BigDecimal.TEN.multiply(BigDecimal.valueOf(typ)).multiply(BigDecimal.valueOf(days)).add(getEnergia()).add(getWoda());
  }
}
