package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Osoba {

  private final Long id;
  private final String imie;
  private final String nazwisko;
  private List<Rezerwacja> rezerwacje = new ArrayList<>();

  public Osoba(Long id, String imie, String nazwisko) {
    this.id = id;
    this.imie = imie;
    this.nazwisko = nazwisko;
  }

  public Long getId() {
    return id;
  }

  public String getImie() {
    return imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public List<Rezerwacja> getRezerwacje() {
    return rezerwacje;
  }

  public BigDecimal calyKoszt() {
    BigDecimal result = BigDecimal.ZERO;
    for (Rezerwacja rezerwacja : getRezerwacje()) {
      int dorosli = rezerwacja.getDorosli();
      int dzieci = rezerwacja.getDzieci();
      BigDecimal cena = rezerwacja.getWycieczka().getCena();
      BigDecimal add = BigDecimal.valueOf(dorosli).multiply(cena).add(BigDecimal.valueOf(dzieci).multiply(cena.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP)));
      result = result.add(add);
    }
    return result;
  }
}
