package pl.michal.olszewski.matury.pr2017stara;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Zadanie5 {

  public static void main(String args[]) throws IOException {
    System.out.println("Zad 5.1");
    int initialState = 550;
    int tmp = 26;
    LocalDate initialDate = LocalDate.of(2015, 9, 15);
    boolean isOver = true;
    do {
      if (initialDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || initialDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
        //rano
        initialState -= tmp;
        //wieczor
        initialState -= tmp;
      } else {
        initialState -= tmp;
      }
      System.out.println(initialDate + " " + initialState);
      if (initialState < 100) {
        isOver = false;
      } else {
        initialDate = initialDate.plusDays(1);
      }

    } while (isOver);
    System.out.println(initialDate);

    System.out.println("5.2");
    initialDate = LocalDate.of(2015, 9, 15);

    int result = 0;
    int gasResult = 0;
    int woodenResult = 0;
    initialState = 550;
    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
        //rano
        if (initialState > tmp) {
          initialState -= tmp;
        }
        //wieczor
        if (initialState > tmp) {
          woodenResult++;
          initialState -= tmp;

        } else {
          gasResult++;

        }
      } else {

        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
          if (initialState < 100) {
            result++;
            initialState += 300;

          }
        }

        //wieczor
        if (initialState > tmp) {
          woodenResult++;
          initialState -= tmp;
        } else {
          gasResult++;
        }
      }
    }
    System.out.println("5.2 wynik = " + result + " " + gasResult + " " + woodenResult);
    System.out.println("5.3");
    initialState = 550;
    for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
      if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
        //rano
        if (initialState > tmp) {
          initialState -= tmp;
        }
        //wieczor
        if (initialState > tmp) {
          initialState -= tmp;
        }

        System.out.println(date + " ; " + initialState);
      } else {

        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
          if (initialState < 100) {
            initialState += 300;

          }
        }

        //wieczor
        if (initialState > tmp) {
          initialState -= tmp;
        }

        System.out.println(date + " ; " + initialState);
      }
    }
    System.out.println("5.4");


    int addWooden = 300;
    isOver = true;

    do {
      initialState = 550;
      gasResult = 0;
      addWooden++;
      System.out.println(addWooden);

      for (LocalDate date : initialDate.datesUntil(LocalDate.of(2016, 4, 1)).collect(Collectors.toList())) {
        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
          //rano
          if (initialState >= tmp) {
            initialState -= tmp;
          }
          //wieczor
          if (initialState >= tmp) {
            initialState -= tmp;
          } else {
            gasResult++;
          }
        } else {

          if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            if (initialState < 100) {
              initialState += addWooden;
            }
          }

          //wieczor
          if (initialState >= tmp) {
            initialState -= tmp;
          } else {
            gasResult++;
          }
        }
      }
      if (gasResult == 0) {
        isOver = false;
      }

    } while (isOver);
    System.out.println("Musi dostarczac " + addWooden);

  }

}
