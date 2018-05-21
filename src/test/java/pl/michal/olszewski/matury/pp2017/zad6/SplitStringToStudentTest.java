package pl.michal.olszewski.matury.pp2017.zad6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SplitStringToStudentTest {

  @Test
  void shouldSplitLineToStudentPojo() {
    String line = "1600\tMateusz\tZgid\tA\t3";
    Student student = SplitLineToStudentPOJO.split(line);
    assertThat(student.getId()).isEqualTo(1600L);
    assertThat(student.getName()).isEqualTo("Mateusz");
    assertThat(student.getLastName()).isEqualTo("Zgid");
    assertThat(student.getClassSymbol()).isEqualTo("A");
    assertThat(student.getRok()).isEqualTo(3L);
  }
}