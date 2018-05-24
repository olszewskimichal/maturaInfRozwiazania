package pl.michal.olszewski.matury.pr2017nowa.zad4;

import java.time.LocalDate;

class SugarTransaction {

  private final LocalDate date;
  private final String nip;
  private final int sugarCount;

  SugarTransaction(LocalDate date, String nip, int sugarCount) {
    this.date = date;
    this.nip = nip;
    this.sugarCount = sugarCount;
  }

  LocalDate getDate() {
    return date;
  }

  String getNip() {
    return nip;
  }

  int getSugarCount() {
    return sugarCount;
  }

}
