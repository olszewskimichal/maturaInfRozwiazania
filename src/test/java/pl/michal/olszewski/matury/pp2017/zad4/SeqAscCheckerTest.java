package pl.michal.olszewski.matury.pp2017.zad4;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.michal.olszewski.matury.pp2017.zad4.SeqAscChecker.isValid;

import org.junit.jupiter.api.Test;

class SeqAscCheckerTest {

  @Test
  void shouldReturnTrueWhenSequenceIsAscending() {
    assertThat(isValid("1", "2", "3")).isTrue();
  }

  @Test
  void shouldReturnFalseWhenSequenceIsDescending() {
    assertThat(isValid("3", "2", "1")).isFalse();
  }

  @Test
  void shouldReturnFalseWhenSequenceIsMixed() {
    assertThat(isValid("2", "3", "1")).isFalse();
  }

}