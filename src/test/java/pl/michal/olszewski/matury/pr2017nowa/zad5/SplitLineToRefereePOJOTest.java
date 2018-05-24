package pl.michal.olszewski.matury.pr2017nowa.zad5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitLineToRefereePOJOTest {
  @Test
  void shouldSplitLineToRefereePOJO() {
    String line = "AC6776\tDanuta\tSliwinska";
    Referee referee = SplitLineToRefereePOJO.split(line);
    assertThat(referee.getLicenceNum()).isEqualTo("AC6776");
  }

}