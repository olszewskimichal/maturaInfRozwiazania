package pl.michal.olszewski.matury.pr2017nowa.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

class ClientDiscountCalculatorTest {

  @Test
  void shouldReturnDiscountZeroIfSugarCountIsLessThen100() {
    List<SugarTransaction> sugarTransactions = new ArrayList<>();
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 99));
    Entry<String, List<SugarTransaction>> entry = Map.entry("111", sugarTransactions);

    BigDecimal discount = ClientDiscountCalculator.sumDiscountForClient(entry);

    assertThat(discount).isEqualTo(BigDecimal.ZERO);
  }

  @Test
  void shouldReturnDiscountNonZeroIfSugarCountIsEqual100() {
    List<SugarTransaction> sugarTransactions = new ArrayList<>();
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 100));
    Entry<String, List<SugarTransaction>> entry = Map.entry("111", sugarTransactions);

    BigDecimal discount = ClientDiscountCalculator.sumDiscountForClient(entry);

    assertThat(discount.stripTrailingZeros()).isEqualTo(BigDecimal.valueOf(5).stripTrailingZeros());
  }

  @Test
  void shouldReturnDiscountNonZeroIfSugarCountIsMoreThen100ButLessThen1000() {
    List<SugarTransaction> sugarTransactions = new ArrayList<>();
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 100));
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 899));
    Entry<String, List<SugarTransaction>> entry = Map.entry("111", sugarTransactions);

    BigDecimal discount = ClientDiscountCalculator.sumDiscountForClient(entry);

    assertThat(discount).isEqualTo(BigDecimal.valueOf(49.95));
  }

  @Test
  void shouldReturnDiscountNonZeroIfSugarCountIsMoreThen1000() {
    List<SugarTransaction> sugarTransactions = new ArrayList<>();
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 100));
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 899));
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 500));
    Entry<String, List<SugarTransaction>> entry = Map.entry("111", sugarTransactions);

    BigDecimal discount = ClientDiscountCalculator.sumDiscountForClient(entry);

    assertThat(discount).isEqualTo(BigDecimal.valueOf(49.95).add(BigDecimal.valueOf(50)));
  }

  @Test
  void shouldReturnDiscountNonZeroIfSugarCountIsMoreThen1000WithNotOrderedCollection() {
    List<SugarTransaction> sugarTransactions = new ArrayList<>();
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 100));
    sugarTransactions.add(new SugarTransaction(LocalDate.now().minusDays(1), "111", 999));
    sugarTransactions.add(new SugarTransaction(LocalDate.now(), "111", 500));
    Entry<String, List<SugarTransaction>> entry = Map.entry("111", sugarTransactions);

    BigDecimal discount = ClientDiscountCalculator.sumDiscountForClient(entry);

    assertThat(discount).isEqualTo(BigDecimal.valueOf(49.95).add(BigDecimal.valueOf(60)));
  }

}