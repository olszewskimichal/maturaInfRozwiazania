package pl.michal.olszewski.matury.pr2017nowa.zad4;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static pl.michal.olszewski.matury.pr2017nowa.zad4.ClientDiscountCalculator.sumDiscountForClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Zadanie4 {


  public static void main(String args[]) throws IOException {
    Map<Integer, BigDecimal> costFromFile = readCostFromFile();
    Set<SugarTransaction> sugarTransactions = readSugarTransactionFromFile();

    System.out.println("zad 4.1 - numery 3 klientów którzy kupili najwiecej cukru");

    Map<String, List<SugarTransaction>> sugarTransactionPerClient = sugarTransactions
        .stream()
        .collect(Collectors.groupingBy(SugarTransaction::getNip));

    sugarTransactionPerClient
        .entrySet()
        .stream()
        .sorted((v1, v2) -> Integer.compare(getTransactionSum(v2), getTransactionSum(v1)))
        .limit(3)
        .forEach(v -> System.out.println(v.getKey() + " " + getTransactionSum(v)));

    System.out.println("zad 4.2 - łaczny przychód to");

    BigDecimal sumOfPrice = sugarTransactions
        .stream()
        .map(v -> costFromFile.getOrDefault(v.getDate().getYear(), ZERO).multiply(valueOf(v.getSugarCount())))
        .reduce(ZERO, BigDecimal::add);

    System.out.println("zad 4.2 - wynik " + sumOfPrice);

    System.out.println("zad 4.3 - ilość sprzedanego cukru w każdym roku");
    sugarTransactions
        .stream()
        .collect(Collectors.groupingBy(v -> v.getDate().getYear()))
        .entrySet()
        .forEach(v -> System.out.println(v.getKey() + " " + getTransactionSum2(v)));

    System.out.println("Zad 4.4 - łączna suma rabatu");
    BigDecimal discount = BigDecimal.ZERO;
    for (Entry<String, List<SugarTransaction>> entry : sugarTransactionPerClient.entrySet()) {
      discount = discount.add(sumDiscountForClient(entry));
    }
    System.out.println("Suma rabatu wynosi = " + discount);

    System.out.println("Zad 4.5");

    int sugarCount = 5000;
    int dostawWiekszychNiz3 = 0;
    Map<Integer, List<SugarTransaction>> transactionPerYear = sugarTransactions.stream()
        .sorted(Comparator.comparing(SugarTransaction::getDate))
        .collect(Collectors.groupingBy(v -> v.getDate().getYear()));

    for (Entry<Integer, List<SugarTransaction>> entry : transactionPerYear.entrySet()) {
      Map<Month, List<SugarTransaction>> transactionPerMonth = entry.getValue()
          .stream()
          .collect(Collectors.groupingBy(v -> v.getDate().getMonth()));
      for (Entry<Month, List<SugarTransaction>> monthListEntry : transactionPerMonth.entrySet()) {
        int sumPerMonth = monthListEntry.getValue().stream()
            .mapToInt(SugarTransaction::getSugarCount)
            .sum();
        int diff = sugarCount - sumPerMonth;
        int deliverCount = ((5000 - diff) + 999) / 1000;
        sugarCount = diff + deliverCount * 1000;
        if (deliverCount > 3) {
          dostawWiekszychNiz3++;
        }
      }

    }
    System.out.println("Wynik 4.5 " + dostawWiekszychNiz3);


  }
  private static int getTransactionSum2(Entry<Integer, List<SugarTransaction>> v2) {
    return v2.getValue().stream()
        .mapToInt(SugarTransaction::getSugarCount)
        .sum();
  }

  private static int getTransactionSum(Entry<String, List<SugarTransaction>> v2) {
    return v2.getValue()
        .stream()
        .mapToInt(SugarTransaction::getSugarCount)
        .sum();
  }

  private static Set<SugarTransaction> readSugarTransactionFromFile() throws IOException {
    return Files.readAllLines(Paths.get("cukier.txt"))
        .stream()
        .map(SplitLineToSugarTransactionPOJO::split)
        .collect(Collectors.toSet());
  }

  private static Map<Integer, BigDecimal> readCostFromFile() throws IOException {
    Map<Integer, BigDecimal> map = new HashMap<>();
    for (String s : Files.readAllLines(Paths.get("cennik.txt"))) {
      String[] split = s.replaceAll(",", ".").split("\t");
      map.put(Integer.valueOf(split[0].trim()), new BigDecimal(split[1]));
    }
    return map;
  }


}
