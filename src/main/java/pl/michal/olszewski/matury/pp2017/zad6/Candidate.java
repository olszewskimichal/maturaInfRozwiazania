package pl.michal.olszewski.matury.pp2017.zad6;

import java.util.ArrayList;
import java.util.List;

class Candidate {

  private final Long id;
  private final String name;
  private final String lastName;
  private List<Long> votersId = new ArrayList<>();

  Candidate(Long id, String name, String lastName) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
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

  List<Long> getVotersId() {
    return votersId;
  }
}
