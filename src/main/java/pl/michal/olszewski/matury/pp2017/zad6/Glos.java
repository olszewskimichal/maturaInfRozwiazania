package pl.michal.olszewski.matury.pp2017.zad6;

public class Glos {

  private final Long id;
  private final Long uczenId;
  private final Long kandydatId;

  public Glos(Long id, Long uczenId, Long kandydatId) {
    this.id = id;
    this.uczenId = uczenId;
    this.kandydatId = kandydatId;
  }

  public Long getId() {
    return id;
  }

  public Long getUczenId() {
    return uczenId;
  }

  public Long getKandydatId() {
    return kandydatId;
  }
}
