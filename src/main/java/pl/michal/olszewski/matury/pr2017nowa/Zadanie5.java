package pl.michal.olszewski.matury.pr2017nowa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pl.michal.olszewski.matury.pr2017nowa.zad5.MatchPlace;
import pl.michal.olszewski.matury.pr2017nowa.zad5.MatchResult;
import pl.michal.olszewski.matury.pr2017nowa.zad5.MatchType;
import pl.michal.olszewski.matury.pr2017nowa.zad5.Refree;
import pl.michal.olszewski.matury.pr2017nowa.zad5.SplitLineToMatchResultPOJO;
import pl.michal.olszewski.matury.pr2017nowa.zad5.SplitLineToRefreePOJO;
import pl.michal.olszewski.matury.pr2017nowa.zad5.SplitLineToTeamPOJO;
import pl.michal.olszewski.matury.pr2017nowa.zad5.Team;

public class Zadanie5 {


  public static void main(String args[]) throws IOException {
    System.out.println("5.1");
    Set<MatchResult> matchResults = readAllResultsFromFile();
    Set<Refree> refrees = readAllRefreeFromFile();
    Set<Team> teams = readAllTeamsFromFile();
    updateRefreeWithMatchResult(matchResults, refrees);
    updateTeamsWithMatchResult(matchResults, teams);

    teams.stream().filter(v -> v.getCity().equals("Kucykowo"))
        .flatMap(v -> v.getResultList().stream())
        .collect(Collectors.groupingBy(MatchResult::getMatchType))
        .forEach((key, value) -> System.out.println(key + " " + value.size()));

    teams.stream().filter(v -> v.getCity().equals("Kucykowo"))
        .flatMap(v -> v.getResultList().stream())
        .collect(Collectors.groupingBy(v -> v.getMatchDate().getYear()))
        .entrySet()
        .stream()
        .max(Comparator.comparingInt(v2 -> v2.getValue().size()))
        .ifPresent(v -> System.out.println(v.getKey() + " " + v.getValue().size()));

    System.out.println("5.2");
    for (Team team : teams) {
      int sum = team.getResultList()
          .stream()
          .mapToInt(v -> v.getBramkiZdobyte() - v.getBramkiStracone())
          .sum();
      if (sum == 0) {
        System.out.println(team.getName());
      }
    }
    System.out.println("5.3");
    List<MatchResult> awayMatches = matchResults.stream()
        .filter(v -> v.getMatchPlace().equals(MatchPlace.W))
        .collect(Collectors.toList());
    int won = 0;
    int lost = 0;
    int draw = 0;
    for (MatchResult result : awayMatches) {
      if (result.getBramkiZdobyte() > result.getBramkiStracone()) {
        won++;
      } else if (result.getBramkiZdobyte() < result.getBramkiStracone()) {
        lost++;
      } else {
        draw++;
      }
    }
    System.out.println("Wygrali " + won + " przegrali " + lost + " zremisowali " + draw);
    ;
    System.out.println("5.4");
    long count = refrees
        .stream()
        .filter(v -> !v.getMatchResults().stream().map(MatchResult::getMatchType).collect(Collectors.toSet()).contains(MatchType.P))
        .count();
    System.out.println("Wynik 5.4 " + count);

  }


  private static Set<MatchResult> readAllResultsFromFile() throws IOException {
    return Files.readAllLines(Paths.get("wyniki.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToMatchResultPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Set<Refree> readAllRefreeFromFile() throws IOException {
    return Files.readAllLines(Paths.get("sedziowie.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToRefreePOJO::split)
        .collect(Collectors.toSet());
  }

  private static Set<Team> readAllTeamsFromFile() throws IOException {
    return Files.readAllLines(Paths.get("druzyny.txt"))
        .stream()
        .skip(1)
        .map(SplitLineToTeamPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Team findTeamById(Long id, Set<Team> teams) {
    return teams
        .stream()
        .filter(v -> v.getId().equals(id))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono zespolu o id = " + id));
  }

  private static Refree findRefreeById(String licenceNum, Set<Refree> refrees) {
    return refrees
        .stream()
        .filter(v -> v.getLicenceNum().equals(licenceNum))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono sedziego o licencji = " + licenceNum));
  }

  private static void updateTeamsWithMatchResult(Set<MatchResult> results, Set<Team> teams) {
    for (MatchResult result : results) {
      Team teamById = findTeamById(result.getTeamId(), teams);
      teamById.getResultList().add(result);
    }
  }

  private static void updateRefreeWithMatchResult(Set<MatchResult> results, Set<Refree> refrees) {
    for (MatchResult result : results) {
      Refree refreeById = findRefreeById(result.getLicenceNum(), refrees);
      refreeById.getMatchResults().add(result);
    }
  }

}
