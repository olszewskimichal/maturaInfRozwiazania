package pl.michal.olszewski.matury.pp2017.zad6;

import java.util.ArrayList;
import java.util.List;

class Student {

  private final Long id;
  private final String name;
  private final String lastName;
  private final String classSymbol;
  private final Long year;
  private List<Long> idZaglosowanychKandydatow = new ArrayList<>();

  Student(Long id, String name, String lastName, String classSymbol, Long year) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.classSymbol = classSymbol;
    this.year = year;
  }

  Long getId() {
    return id;
  }

  String getName() {
    return name;
  }

  String getLastName() {
    return lastName;
  }

  String getClassSymbol() {
    return classSymbol;
  }

  Long getYear() {
    return year;
  }

  List<Long> getIdZaglosowanychKandydatow() {
    return idZaglosowanychKandydatow;
  }
}
