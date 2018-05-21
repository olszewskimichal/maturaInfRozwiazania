package pl.michal.olszewski.matury.pr2017stara.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TwoCyclingCheckerTest {

  @Test
  void shouldReturnTrueWhenDwucykliczny() {
    assertThat(TwoCyclingChecker.check("10001000")).isTrue();
  }

  @Test
  void shouldReturnFalseWhenIsNotDwucykliczny() {
    assertThat(TwoCyclingChecker.check("00011000")).isFalse();
    assertThat(TwoCyclingChecker.check("10001001")).isFalse();
  }

}