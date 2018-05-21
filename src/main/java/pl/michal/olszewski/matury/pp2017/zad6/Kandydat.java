package pl.michal.olszewski.matury.pp2017.zad6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Kandydat {

  private final Long id;
  private final String name;
  private final String lastName;
  private List<Long> uczniowieGlosujacy = new ArrayList<>();

  public Kandydat(Long id, String name, String lastName) {
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

  public List<Long> getUczniowieGlosujacy() {
    return uczniowieGlosujacy;
  }
}
