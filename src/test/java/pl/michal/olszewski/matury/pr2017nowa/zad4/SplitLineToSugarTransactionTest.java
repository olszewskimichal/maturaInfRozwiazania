package pl.michal.olszewski.matury.pr2017nowa.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SplitLineToSugarTransactionTest {

  @Test
  void shouldSplitLineToSugarTransaction() {
    String line = "2005-01-01\t872-13-44-365\t10";
    SugarTransaction sugarTransaction = SplitLineToSugarTransaction.split(line);
    assertThat(sugarTransaction).isNotNull();
    assertThat(sugarTransaction.getSugarCount()).isNotNull().isEqualTo(10);
    assertThat(sugarTransaction.getNip()).isNotNull().isEqualTo("872-13-44-365");
    assertThat(sugarTransaction.getDate()).isNotNull().isEqualTo(LocalDate.of(2005, 1, 1));
  }
}