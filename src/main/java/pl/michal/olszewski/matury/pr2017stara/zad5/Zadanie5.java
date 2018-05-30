package pl.michal.olszewski.matury.pr2017stara.zad5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Zadanie5 {

  public static void main(String args[]) {
    System.out.println("Zad 5.1");
    LocalDate resultDate = getFirstDeliverDate(LocalDate.of(2015, 9, 14));
    System.out.println(resultDate);

    System.out.println("5.2");
    LocalDate initialDate = LocalDate.of(2015, 9, 15);

    HeatingStatistics heatingStatistics = new HeatingStatistics(550, 300);

    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      heatingStatistics = calculateStatisticForDay(heatingStatistics, date);
    }
    System.out.println("5.2 wynik = " + heatingStatistics);
    System.out.println("5.3");

    heatingStatistics = new HeatingStatistics(550, 300);
    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      heatingStatistics = calculateStatisticForDay(heatingStatistics, date);
      System.out.println(date + " " + heatingStatistics.getWoodenState());
    }
    System.out.println("5.4");

    int woodenDeliver = 300;

    do {
      woodenDeliver++;
      heatingStatistics = new HeatingStatistics(550, woodenDeliver);

      for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
        heatingStatistics = calculateStatisticForDay(heatingStatistics, date);
      }
    } while (heatingStatistics.getGasEveningHeatingCount() != 0);
    System.out.println("Musi dostarczac " + woodenDeliver);

  }

  private static HeatingStatistics calculateStatisticForDay(HeatingStatistics heatingStatistics, LocalDate date) {
    if (isWeekend(date)) {
      heatingStatistics = heatingStatistics.weekendMorningHeating();
      heatingStatistics = heatingStatistics.eveningHeating();
    } else {
      heatingStatistics = heatingStatistics.weekDayMorningHeating();
      if (isFriday(date)) {
        heatingStatistics = heatingStatistics.fridayWoodenDelivering();
      }
      heatingStatistics = heatingStatistics.eveningHeating();
    }
    return heatingStatistics;
  }

  private static boolean isFriday(LocalDate date) {
    return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
  }

  private static LocalDate getFirstDeliverDate(LocalDate initialDate) {

    HeatingStatistics heatingStatistics = new HeatingStatistics(550, 300);
    do {
      initialDate = initialDate.plusDays(1);
      heatingStatistics = calculateStatisticForDay(heatingStatistics, initialDate);
    } while (heatingStatistics.getWoodenState() > 100);
    return initialDate;
  }

  private static boolean isWeekend(LocalDate initialDate) {
    return initialDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || initialDate.getDayOfWeek().equals(DayOfWeek.SATURDAY);
  }

}
