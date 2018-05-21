package pl.michal.olszewski.matury.pp2017.zad6;

public class Vote {

  private final Long id;
  private final Long studentId;
  private final Long candidateId;

  Vote(Long id, Long studentId, Long candidateId) {
    this.id = id;
    this.studentId = studentId;
    this.candidateId = candidateId;
  }

  public Long getId() {
    return id;
  }

  public Long getStudentId() {
    return studentId;
  }

  public Long getCandidateId() {
    return candidateId;
  }
}
