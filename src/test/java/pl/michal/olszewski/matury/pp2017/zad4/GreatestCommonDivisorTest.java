package pl.michal.olszewski.matury.pp2017.zad4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreatestCommonDivisorTest {

  GreatestCommonDivisor divisor = new GreatestCommonDivisor();

  @Test
  void testGCD() {
    assertThat(divisor.calculate(3, 6, 9)).isEqualTo(3);
    assertThat(divisor.calculate(34, 10, 4)).isEqualTo(2);
    assertThat(divisor.calculate(36, 20, 28)).isEqualTo(4);
    assertThat(divisor.calculate(16, 40, 56)).isEqualTo(8);
  }

}