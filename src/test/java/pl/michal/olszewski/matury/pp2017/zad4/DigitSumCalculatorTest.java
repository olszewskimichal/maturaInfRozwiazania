package pl.michal.olszewski.matury.pp2017.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DigitSumCalculatorTest {

  @Test
  void shouldCalculateSumOfNumFromString() {
    assertThat(DigitSumCalculator.calculate("123")).isEqualTo(6);
  }
}