package pl.michal.olszewski.matury.pr2017stara;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pr2017stara.zad6.Person;
import pl.michal.olszewski.matury.pr2017stara.zad6.Reservation;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitLineToPersonPOJO;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitLineToReservationPOJO;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitLineToTripPOJO;
import pl.michal.olszewski.matury.pr2017stara.zad6.Trip;

public class Zadanie6 {

  public static void main(String args[]) throws IOException {
    Set<Person> people = readAllOsobyFromFile();
    Set<Trip> trips = readAllWycieczkiFromFile();
    Set<Reservation> reservations = readAllRezerwacjeFromFile();
    updateOsoby(people, reservations);
    updateWycieczki(trips, reservations);

    System.out.println("zad 6.1");
    people.stream()
        .filter(v -> v.getReservations().size() > 3)
        .sorted(Comparator.comparing(Person::getLastName))
        .forEach(v -> System.out.println(v.getName() + " " + v.getLastName()));

    System.out.println("zad 6.2");
    people.stream()
        .max(Comparator.comparing(Person::calyKoszt))
        .ifPresent(v -> System.out.println(v.getName() + " " + v.getLastName() + " " + v.calyKoszt()));

    System.out.println("zad 6.3");

    reservations.stream()
        .collect(Collectors.groupingBy(v -> v.getTrip().getFrom().getMonth()))
        .forEach((key, value) -> System.out.println(key + " " + value.size()));

    System.out.println("zad 6.4");

    for (Entry<String, List<Trip>> entry : trips.stream()
        .collect(Collectors.groupingBy(Trip::getEscape))
        .entrySet()) {
      System.out.println(entry.getKey());
      entry.getValue().stream().collect(Collectors.groupingBy(Trip::getCountry))
          .forEach((key, value) -> System.out.println(key + " " + value.size()));
      System.out.println();
    }

  }

  private static void updateOsoby(Set<Person> osoby, Set<Reservation> rezerwacje) {
    for (Reservation reservation : rezerwacje) {
      Person personById = findOsobaById(reservation.getIdOsoby(), osoby);
      personById.getReservations().add(reservation);
    }
  }

  private static void updateWycieczki(Set<Trip> wycieczki, Set<Reservation> rezerwacje) {
    for (Reservation reservation : rezerwacje) {
      Trip tripById = findWycieczkaById(reservation.getIdWycieczki(), wycieczki);
      tripById.getReservations().add(reservation);
      reservation.setTrip(tripById);
    }
  }

  private static Set<Person> readAllOsobyFromFile() throws IOException {
    return Files.readAllLines(Paths.get("osoby.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToPersonPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Set<Trip> readAllWycieczkiFromFile() throws IOException {
    return Files.readAllLines(Paths.get("wycieczki.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToTripPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Set<Reservation> readAllRezerwacjeFromFile() throws IOException {
    return Files.readAllLines(Paths.get("rezerwacje.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToReservationPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Trip findWycieczkaById(Long id, Set<Trip> candidates) {
    return candidates
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono wycieczka o id = " + id));
  }

  private static Person findOsobaById(Long id, Set<Person> osoby) {
    return osoby
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono osoby o id = " + id));
  }


}
