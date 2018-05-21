package pl.michal.olszewski.matury.pp2017.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitStringToUczenTest {

  @Test
  void shouldSplitLineToUczenPojo() {
    String line = "1600\tMateusz\tZgid\tA\t3";
    Uczen uczen = SplitLineToUczenPOJO.split(line);
    assertThat(uczen.getId()).isEqualTo(1600L);
    assertThat(uczen.getName()).isEqualTo("Mateusz");
    assertThat(uczen.getLastName()).isEqualTo("Zgid");
    assertThat(uczen.getClassSymbol()).isEqualTo("A");
    assertThat(uczen.getRok()).isEqualTo(3L);
  }
}