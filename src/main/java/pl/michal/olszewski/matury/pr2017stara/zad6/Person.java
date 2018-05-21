package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Person {

  private final Long id;
  private final String name;
  private final String lastName;
  private List<Reservation> reservations = new ArrayList<>();

  public Person(Long id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public BigDecimal calyKoszt() {
    BigDecimal result = BigDecimal.ZERO;
    for (Reservation reservation : getReservations()) {
      int dorosli = reservation.getDorosli();
      int dzieci = reservation.getDzieci();
      BigDecimal cena = reservation.getTrip().getPrice();
      BigDecimal add = BigDecimal.valueOf(dorosli).multiply(cena).add(BigDecimal.valueOf(dzieci).multiply(cena.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP)));
      result = result.add(add);
    }
    return result;
  }
}
