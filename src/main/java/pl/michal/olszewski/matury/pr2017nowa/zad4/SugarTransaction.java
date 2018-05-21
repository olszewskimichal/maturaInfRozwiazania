package pl.michal.olszewski.matury.pr2017nowa.zad4;

import java.time.LocalDate;

public class SugarTransaction {

  private final LocalDate date;
  private final String nip;
  private final int sugarCount;

  public SugarTransaction(LocalDate date, String nip, int sugarCount) {
    this.date = date;
    this.nip = nip;
    this.sugarCount = sugarCount;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getNip() {
    return nip;
  }

  public int getSugarCount() {
    return sugarCount;
  }

  @Override
  public String toString() {
    return "ST{" +
        " sugarCount=" + sugarCount +
        '}';
  }
}
