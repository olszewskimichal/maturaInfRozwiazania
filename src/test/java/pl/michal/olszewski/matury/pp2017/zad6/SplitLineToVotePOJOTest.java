package pl.michal.olszewski.matury.pp2017.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitLineToVotePOJOTest {

  @Test
  void shouldSplitLineToVotePOJO() {
    String line = "1\t1739\t11";
    Vote vote = SplitLineToVotePOJO.split(line);
    assertThat(vote.getId()).isEqualTo(1L);
    assertThat(vote.getCandidateId()).isEqualTo(11L);
    assertThat(vote.getStudentId()).isEqualTo(1739L);
  }
}