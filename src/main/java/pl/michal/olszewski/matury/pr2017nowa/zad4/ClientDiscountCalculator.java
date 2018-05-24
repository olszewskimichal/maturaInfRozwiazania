package pl.michal.olszewski.matury.pr2017nowa.zad4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class ClientDiscountCalculator {

  static BigDecimal sumDiscountForClient(Entry<String, List<SugarTransaction>> entry) {
    int sugarCount = 0;
    BigDecimal clientDiscount = BigDecimal.ZERO;
    for (SugarTransaction transaction : entry.getValue()
        .stream()
        .sorted(Comparator.comparing(SugarTransaction::getDate)).collect(Collectors.toList())) {
      sugarCount += transaction.getSugarCount();
      if (sugarCount >= 100 && sugarCount < 1000) {
        clientDiscount = clientDiscount.add(BigDecimal.valueOf(0.05).multiply(BigDecimal.valueOf(transaction.getSugarCount())));
      } else if (sugarCount >= 1000 && sugarCount < 10000) {
        clientDiscount = clientDiscount.add(BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(transaction.getSugarCount())));
      } else if (sugarCount >= 10000) {
        clientDiscount = clientDiscount.add(BigDecimal.valueOf(0.2).multiply(BigDecimal.valueOf(transaction.getSugarCount())));
      }
    }
    return clientDiscount;
  }

}
