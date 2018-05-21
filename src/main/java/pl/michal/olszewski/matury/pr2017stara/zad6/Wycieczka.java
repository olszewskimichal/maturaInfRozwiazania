package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wycieczka {

  private final Long id;
  private final String kraj;
  private final String miejsce;
  private final String wylot;
  private final LocalDate dataOd;
  private final LocalDate dataDo;
  private final BigDecimal cena;
  private List<Rezerwacja> rezerwacje = new ArrayList<>();

  public Wycieczka(Long id, String kraj, String miejsce, String wylot, LocalDate dataOd, LocalDate dataDo, BigDecimal cena) {
    this.id = id;
    this.kraj = kraj;
    this.miejsce = miejsce;
    this.wylot = wylot;
    this.dataOd = dataOd;
    this.dataDo = dataDo;
    this.cena = cena;
  }

  public Long getId() {
    return id;
  }

  public String getKraj() {
    return kraj;
  }

  public String getMiejsce() {
    return miejsce;
  }

  public String getWylot() {
    return wylot;
  }

  public LocalDate getDataOd() {
    return dataOd;
  }

  public LocalDate getDataDo() {
    return dataDo;
  }

  public BigDecimal getCena() {
    return cena;
  }

  public List<Rezerwacja> getRezerwacje() {
    return rezerwacje;
  }



}
