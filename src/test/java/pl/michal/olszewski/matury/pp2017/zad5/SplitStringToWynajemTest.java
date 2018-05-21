package pl.michal.olszewski.matury.pp2017.zad5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SplitStringToWynajemTest {

  @Test
  void shouldSplitLineToWynajemPojo() {
    //given
    String line = "2014-01-02\t2014-01-11\t39,35\t1,04\t5";
    //when
    Wynajem wynajem = SplitLineToWynajemPOJO.split(line);
    //then
    assertThat(wynajem.getDataPrzyjazdu()).isNotNull().isEqualTo(LocalDate.of(2014, 1, 2));
    assertThat(wynajem.getDataWyjazdu()).isNotNull().isEqualTo(LocalDate.of(2014, 1, 11));
    assertThat(wynajem.getEnergia()).isNotNull().isEqualTo(new BigDecimal("39.35"));
    assertThat(wynajem.getWoda()).isNotNull().isEqualTo(new BigDecimal("1.04"));
    assertThat(wynajem.getTyp()).isNotNull().isEqualTo(5L);
    assertThat(wynajem.sumaWydatkow()).isEqualTo(new BigDecimal("490.39"));
  }
}