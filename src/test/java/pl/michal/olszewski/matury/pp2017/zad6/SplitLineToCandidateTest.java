package pl.michal.olszewski.matury.pp2017.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitLineToCandidateTest {

  @Test
  void shouldSplitLineToKandydatPOJO() {
    String line = "1\tFaustyn\tAugustowski";
    Candidate candidate = SplitLineToCandidatePOJO.split(line);
    assertThat(candidate.getId()).isEqualTo(1L);
    assertThat(candidate.getName()).isEqualTo("Faustyn");
    assertThat(candidate.getLastName()).isEqualTo("Augustowski");
  }
}