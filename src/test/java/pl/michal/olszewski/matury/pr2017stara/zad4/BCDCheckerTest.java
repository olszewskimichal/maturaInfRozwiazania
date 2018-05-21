package pl.michal.olszewski.matury.pr2017stara.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BCDCheckerTest {

  @Test
  void shouldReturnTrueWhenIsBCD() {
    assertThat(BCDChecker.check("10010111")).isTrue();
  }

  @Test
  void shouldReturnFalseWhenIsNotBCD() {
    assertThat(BCDChecker.check("11010000")).isFalse();
  }

}