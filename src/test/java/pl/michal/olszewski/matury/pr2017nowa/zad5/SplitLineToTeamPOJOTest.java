package pl.michal.olszewski.matury.pr2017nowa.zad5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitLineToTeamPOJOTest {

  @Test
  void shouldSplitLineToTeamPOJO() {
    String line = "1\tSrebrne Pumy\tOlsztyn";
    Team team = SplitLineToTeamPOJO.split(line);
    assertThat(team.getId()).isEqualTo(1L);
    assertThat(team.getName()).isEqualTo("Srebrne Pumy");
    assertThat(team.getCity()).isEqualTo("Olsztyn");
  }

}