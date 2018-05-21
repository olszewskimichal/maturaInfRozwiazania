package pl.michal.olszewski.matury.pp2017.zad6;

import java.util.ArrayList;
import java.util.List;

public class Candidate {

  private final Long id;
  private final String name;
  private final String lastName;
  private List<Long> votersId = new ArrayList<>();

  public Candidate(Long id, String name, String lastName) {
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

  public List<Long> getVotersId() {
    return votersId;
  }
}
