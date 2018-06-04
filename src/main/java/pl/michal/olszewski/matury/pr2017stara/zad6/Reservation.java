package pl.michal.olszewski.matury.pr2017stara.zad6;

class Reservation {

  private final Long id;
  private final Long idOsoby;
  private final Long idWycieczki;
  private final int dorosli;
  private final int dzieci;
  private Trip trip;

  Reservation(Long id, Long idOsoby, Long idWycieczki, int dorosli, int dzieci) {
    this.id = id;
    this.idOsoby = idOsoby;
    this.idWycieczki = idWycieczki;
    this.dorosli = dorosli;
    this.dzieci = dzieci;
  }

  Long getId() {
    return id;
  }

  Long getIdOsoby() {
    return idOsoby;
  }

  Long getIdWycieczki() {
    return idWycieczki;
  }

  int getDorosli() {
    return dorosli;
  }

  int getDzieci() {
    return dzieci;
  }

  Trip getTrip() {
    return trip;
  }

  void setTrip(Trip trip) {
    this.trip = trip;
  }
}
