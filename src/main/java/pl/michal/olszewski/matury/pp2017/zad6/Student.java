package pl.michal.olszewski.matury.pp2017.zad6;

import java.util.ArrayList;
import java.util.List;

public class Student {

  private final Long id;
  private final String name;
  private final String lastName;
  private final String classSymbol;
  private final Long rok;
  private List<Long> idZaglosowanychKandydatow = new ArrayList<>();

  public Student(Long id, String name, String lastName, String classSymbol, Long rok) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.classSymbol = classSymbol;
    this.rok = rok;
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

  public String getClassSymbol() {
    return classSymbol;
  }

  public Long getRok() {
    return rok;
  }

  public List<Long> getIdZaglosowanychKandydatow() {
    return idZaglosowanychKandydatow;
  }
}
