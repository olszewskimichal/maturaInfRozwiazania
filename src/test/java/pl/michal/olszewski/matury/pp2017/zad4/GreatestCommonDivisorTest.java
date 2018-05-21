package pl.michal.olszewski.matury.pp2017.zad4;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.michal.olszewski.matury.pp2017.zad4.GreatestCommonDivisor.calculate;

import org.junit.jupiter.api.Test;

class GreatestCommonDivisorTest {

  @Test
  void testGCD() {
    assertThat(calculate(3, 6, 9)).isEqualTo(3);
    assertThat(calculate(34, 10, 4)).isEqualTo(2);
    assertThat(calculate(36, 20, 28)).isEqualTo(4);
    assertThat(calculate(16, 40, 56)).isEqualTo(8);
  }

}