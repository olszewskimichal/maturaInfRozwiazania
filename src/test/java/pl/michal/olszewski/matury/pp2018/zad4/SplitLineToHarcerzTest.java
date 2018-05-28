package pl.michal.olszewski.matury.pp2018.zad4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class SplitLineToHarcerzTest {

  @Test
  void shouldSplitLineToHarcerzPOJO() {
    //given
    String line = "H001;Konrad;Jedruszczak;Bukowina";
    //when
    Harcerz harcerz = SplitLineToHarcerz.split(line);
    //then
    assertAll(
        () -> assertThat(harcerz.getName()).isNotNull().isEqualTo("Konrad"),
        () -> assertThat(harcerz.getLastName()).isNotNull().isEqualTo("Jedruszczak"),
        () -> assertThat(harcerz.getTeam()).isNotNull().isEqualTo("Bukowina"),
        () -> assertThat(harcerz.getId()).isNotNull().isEqualTo("H001")
    );

  }
}