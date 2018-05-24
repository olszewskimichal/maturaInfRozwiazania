package pl.michal.olszewski.matury.pr2017nowa.zad5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SplitLineToMatchResultPOJOTest {

  @Test
  void shouldSplitLineToMatchResultPOJO() {
    String line = "2006-10-28\tP\tD\t28\tAC6776\t2\t5";
    MatchResult matchResult = SplitLineToMatchResultPOJO.split(line);
    assertAll(
        () -> assertThat(matchResult.getMatchDate()).isEqualTo(LocalDate.of(2006, 10, 28)),
        () -> assertThat(matchResult.getMatchType()).isEqualTo(MatchType.P),
        () -> assertThat(matchResult.getMatchPlace()).isEqualTo(MatchPlace.D),
        () -> assertThat(matchResult.getBramkiStracone()).isEqualTo(5),
        () -> assertThat(matchResult.getBramkiZdobyte()).isEqualTo(2),
        () -> assertThat(matchResult.getLicenceNum()).isEqualTo("AC6776")
        );
  }

}