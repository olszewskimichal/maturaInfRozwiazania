package pl.michal.olszewski.matury.pr2017stara.zad6;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Trip {

  private final Long id;
  private final String country;
  private final String escape;
  private final LocalDate from;
  private final BigDecimal price;
  private List<Reservation> reservations = new ArrayList<>();

  Trip(Long id, String kraj, String escape, LocalDate from, BigDecimal price) {
    this.id = id;
    this.country = kraj;
    this.escape = escape;
    this.from = from;
    this.price = price;
  }

  Long getId() {
    return id;
  }

  String getCountry() {
    return country;
  }

  String getEscape() {
    return escape;
  }

  LocalDate getFrom() {
    return from;
  }

  BigDecimal getPrice() {
    return price;
  }

  List<Reservation> getReservations() {
    return reservations;
  }


}
