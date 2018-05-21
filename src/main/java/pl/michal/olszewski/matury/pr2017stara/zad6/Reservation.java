package pl.michal.olszewski.matury.pr2017stara.zad6;

public class Reservation {

  private final Long id;
  private final Long idOsoby;
  private final Long idWycieczki;
  private final int dorosli;
  private final int dzieci;
  private Trip trip;

  public Reservation(Long id, Long idOsoby, Long idWycieczki, int dorosli, int dzieci) {
    this.id = id;
    this.idOsoby = idOsoby;
    this.idWycieczki = idWycieczki;
    this.dorosli = dorosli;
    this.dzieci = dzieci;
  }

  public Long getId() {
    return id;
  }

  public Long getIdOsoby() {
    return idOsoby;
  }

  public Long getIdWycieczki() {
    return idWycieczki;
  }

  public int getDorosli() {
    return dorosli;
  }

  public int getDzieci() {
    return dzieci;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }
}
