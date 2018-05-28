package pl.michal.olszewski.matury.pp2018.zad4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SplitLineToDzialaniaPOJOTest {

  @Test
  void shouldSplitToDzialania() {
    //given
    String line = "H019;2017-01-11;2017-01-13;S1;150";
    //when
    Dzialania dzialania = SplitLineToDzialaniaPOJO.split(line);
    //then
    assertAll(
        () -> assertThat(dzialania.getFrom()).isNotNull().isEqualTo(LocalDate.of(2017, 1, 11)),
        () -> assertThat(dzialania.getTo()).isNotNull().isEqualTo(LocalDate.of(2017, 1, 13)),
        () -> assertThat(dzialania.getPoints()).isNotNull().isEqualTo(150),
        () -> assertThat(dzialania.getSprawnoscId()).isNotNull().isEqualTo("S1"),
        () -> assertThat(dzialania.getHarcerzId()).isNotNull().isEqualTo("H019")
    );
  }
}