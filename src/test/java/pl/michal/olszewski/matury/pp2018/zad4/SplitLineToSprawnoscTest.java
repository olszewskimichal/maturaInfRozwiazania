package pl.michal.olszewski.matury.pp2018.zad4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class SplitLineToSprawnoscTest {

  @Test
  void split() {
    //given
    String line = "S1;zeglarz";
    //when
    Sprawnosc sprawnosc = SplitLineToSprawnosc.split(line);
    //then
    assertAll(
        () -> assertThat(sprawnosc.getName()).isNotNull().isEqualTo("zeglarz"),
        () -> assertThat(sprawnosc.getId()).isNotNull().isEqualTo("S1")
    );
  }
}