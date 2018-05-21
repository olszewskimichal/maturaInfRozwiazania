package pl.michal.olszewski.matury.pp2017.zad5;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SplitStringToRentTest {

  @Test
  void shouldSplitLineToRentPojo() {
    //given
    String line = "2014-01-02\t2014-01-11\t39,35\t1,04\t5";
    //when
    Rent rent = SplitLineToRentPOJO.split(line);
    //then
    assertThat(rent.getFrom()).isNotNull().isEqualTo(LocalDate.of(2014, 1, 2));
    assertThat(rent.getTo()).isNotNull().isEqualTo(LocalDate.of(2014, 1, 11));
    assertThat(rent.getEnergy()).isNotNull().isEqualTo(new BigDecimal("39.35"));
    assertThat(rent.getWater()).isNotNull().isEqualTo(new BigDecimal("1.04"));
    assertThat(rent.getType()).isNotNull().isEqualTo(5L);
    assertThat(rent.sumaWydatkow()).isEqualTo(new BigDecimal("490.39"));
  }
}