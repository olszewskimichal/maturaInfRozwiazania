package pl.michal.olszewski.matury.pp2017.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitLineToKandydatTest {

  @Test
  void shouldSplitLineToKandydatPOJO() {
    String line = "1\tFaustyn\tAugustowski";
    Kandydat kandydat = SplitLineToKandydat.split(line);
    assertThat(kandydat.getId()).isEqualTo(1L);
    assertThat(kandydat.getName()).isEqualTo("Faustyn");
    assertThat(kandydat.getLastName()).isEqualTo("Augustowski");
  }
}