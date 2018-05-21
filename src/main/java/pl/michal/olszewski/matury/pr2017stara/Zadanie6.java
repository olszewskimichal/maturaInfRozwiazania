package pl.michal.olszewski.matury.pr2017stara;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pr2017stara.zad6.Osoba;
import pl.michal.olszewski.matury.pr2017stara.zad6.Rezerwacja;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitStringToOsoba;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitStringToRezerwacja;
import pl.michal.olszewski.matury.pr2017stara.zad6.SplitStringToWycieczka;
import pl.michal.olszewski.matury.pr2017stara.zad6.Wycieczka;

public class Zadanie6 {

  public static void main(String args[]) throws IOException {
    Set<Osoba> osobas = readAllOsobyFromFile();
    Set<Wycieczka> wycieczkas = readAllWycieczkiFromFile();
    Set<Rezerwacja> rezerwacjas = readAllRezerwacjeFromFile();
    updateOsoby(osobas, rezerwacjas);
    updateWycieczki(wycieczkas, rezerwacjas);

    System.out.println("zad 6.1");
    osobas.stream()
        .filter(v -> v.getRezerwacje().size() > 3)
        .sorted(Comparator.comparing(Osoba::getNazwisko))
        .forEach(v -> System.out.println(v.getImie() + " " + v.getNazwisko()));

    System.out.println("zad 6.2");
    osobas.stream()
        .max(Comparator.comparing(Osoba::calyKoszt))
        .ifPresent(v -> System.out.println(v.getImie() + " " + v.getNazwisko() + " " + v.calyKoszt()));

    System.out.println("zad 6.3");

    rezerwacjas.stream()
        .collect(Collectors.groupingBy(v -> v.getWycieczka().getDataOd().getMonth()))
        .forEach((key, value) -> System.out.println(key + " " + value.size()));

    System.out.println("zad 6.4");

    for (Entry<String, List<Wycieczka>> entry : wycieczkas.stream()
        .collect(Collectors.groupingBy(Wycieczka::getWylot))
        .entrySet()) {
      System.out.println(entry.getKey());
      entry.getValue().stream().collect(Collectors.groupingBy(Wycieczka::getKraj))
          .forEach((key, value) -> System.out.println(key + " " + value.size()));
      System.out.println();
    }

  }

  private static void updateOsoby(Set<Osoba> osoby, Set<Rezerwacja> rezerwacje) {
    for (Rezerwacja rezerwacja : rezerwacje) {
      Osoba osobaById = findOsobaById(rezerwacja.getIdOsoby(), osoby);
      osobaById.getRezerwacje().add(rezerwacja);
    }
  }

  private static void updateWycieczki(Set<Wycieczka> wycieczki, Set<Rezerwacja> rezerwacje) {
    for (Rezerwacja rezerwacja : rezerwacje) {
      Wycieczka wycieczkaById = findWycieczkaById(rezerwacja.getIdWycieczki(), wycieczki);
      wycieczkaById.getRezerwacje().add(rezerwacja);
      rezerwacja.setWycieczka(wycieczkaById);
    }
  }

  private static Set<Osoba> readAllOsobyFromFile() throws IOException {
    return Files.readAllLines(Paths.get("osoby.txt"))
        .stream()
        .skip(1)
        .map(SplitStringToOsoba::split)
        .collect(Collectors.toSet());
  }

  private static Set<Wycieczka> readAllWycieczkiFromFile() throws IOException {
    return Files.readAllLines(Paths.get("wycieczki.txt"))
        .stream()
        .skip(1)
        .map(SplitStringToWycieczka::split)
        .collect(Collectors.toSet());
  }

  private static Set<Rezerwacja> readAllRezerwacjeFromFile() throws IOException {
    return Files.readAllLines(Paths.get("rezerwacje.txt"))
        .stream()
        .skip(1)
        .map(SplitStringToRezerwacja::split)
        .collect(Collectors.toSet());
  }

  private static Wycieczka findWycieczkaById(Long id, Set<Wycieczka> candidates) {
    return candidates
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono wycieczka o id = " + id));
  }

  private static Osoba findOsobaById(Long id, Set<Osoba> osoby) {
    return osoby
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono osoby o id = " + id));
  }


}
