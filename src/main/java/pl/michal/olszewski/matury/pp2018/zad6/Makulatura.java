package pl.michal.olszewski.matury.pp2018.zad6;

import java.time.LocalDate;

class Makulatura {

  private final LocalDate date;
  private final String name;
  private final String lastName;
  private final Integer kg;

  Makulatura(LocalDate date, String name, String lastName, Integer kg) {
    this.date = date;
    this.name = name;
    this.lastName = lastName;
    this.kg = kg;
  }

  LocalDate getDate() {
    return date;
  }

  String getName() {
    return name;
  }

  String getLastName() {
    return lastName;
  }

  Integer getKg() {
    return kg;
  }

}
