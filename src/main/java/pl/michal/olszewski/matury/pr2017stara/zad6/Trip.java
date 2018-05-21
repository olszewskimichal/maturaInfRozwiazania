package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip {

  private final Long id;
  private final String country;
  private final String escape;
  private final LocalDate from;
  private final BigDecimal price;
  private List<Reservation> reservations = new ArrayList<>();

  public Trip(Long id, String kraj, String escape, LocalDate from, BigDecimal price) {
    this.id = id;
    this.country = kraj;
    this.escape = escape;
    this.from = from;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getCountry() {
    return country;
  }

  public String getEscape() {
    return escape;
  }

  public LocalDate getFrom() {
    return from;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }


}
