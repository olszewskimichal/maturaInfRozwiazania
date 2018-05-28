package pl.michal.olszewski.matury.pr2017stara.zad5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Zadanie5 {

  public static void main(String args[]) {
    System.out.println("Zad 5.1");
    LocalDate resultDate = getFirstDeliverDate(550, 26, LocalDate.of(2015, 9, 14));
    System.out.println(resultDate);

    System.out.println("5.2");
    LocalDate initialDate = LocalDate.of(2015, 9, 15);

    HeatingStatistics heatingStatistics = new HeatingStatistics(550, 300);

    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      heatingStatistics = calculateStatisticForDay(heatingStatistics, date);
    }
    System.out.println("5.2 wynik = " + heatingStatistics);
    System.out.println("5.3");

    int woodenForEachHeating = 26;
    Integer initialState = 550;
    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      if (isWeekend(date)) {
        //rano
        if (initialState > woodenForEachHeating) {
          initialState -= woodenForEachHeating;
        }
        //wieczor
        if (initialState > woodenForEachHeating) {
          initialState -= woodenForEachHeating;
        }

        System.out.println(date + " ; " + initialState);
      } else {

        if (isFriday(date)) {
          if (needWoodenDeliver(initialState)) {
            initialState += getWoodenDeliver();

          }
        }

        //wieczor
        if (initialState > woodenForEachHeating) {
          initialState -= woodenForEachHeating;
        }

        System.out.println(date + " ; " + initialState);
      }
    }
    System.out.println("5.4");

    int addWooden = getWoodenDeliver();
    Boolean isOver = true;

    do {
      initialState = 550;
      int gasEveningHeatingCount = 0;
      addWooden++;
      System.out.println(addWooden);

      for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
        if (isWeekend(date)) {
          //rano
          if (initialState >= woodenForEachHeating) {
            initialState -= woodenForEachHeating;
          }
          //wieczor
          if (initialState >= woodenForEachHeating) {
            initialState -= woodenForEachHeating;
          } else {
            gasEveningHeatingCount++;
          }
        } else {

          if (isFriday(date)) {
            if (needWoodenDeliver(initialState)) {
              initialState += addWooden;
            }
          }

          //wieczor
          if (initialState >= woodenForEachHeating) {
            initialState -= woodenForEachHeating;
          } else {
            gasEveningHeatingCount++;
          }
        }
      }
      if (gasEveningHeatingCount == 0) {
        isOver = false;
      }

    } while (isOver);
    System.out.println("Musi dostarczac " + addWooden);

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

  private static int getWoodenDeliver() {
    return 300;
  }

  private static boolean needWoodenDeliver(Integer initialState) {
    return initialState < 100;
  }

  private static boolean isFriday(LocalDate date) {
    return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
  }

  private static LocalDate getFirstDeliverDate(int initialState, int woodenForEachHeating, LocalDate initialDate) {
    do {
      initialDate = initialDate.plusDays(1);
      if (isWeekend(initialDate)) {
        //rano
        initialState -= woodenForEachHeating;
        //wieczor
        initialState -= woodenForEachHeating;
      } else {
        initialState -= woodenForEachHeating;
      }
    } while (initialState > 100);
    return initialDate;
  }

  private static boolean isWeekend(LocalDate initialDate) {
    return initialDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || initialDate.getDayOfWeek().equals(DayOfWeek.SATURDAY);
  }

}
