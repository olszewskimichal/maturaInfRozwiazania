package pl.michal.olszewski.matury.pp2017.zad6;

class Vote {

  private final Long id;
  private final Long studentId;
  private final Long candidateId;

  Vote(Long id, Long studentId, Long candidateId) {
    this.id = id;
    this.studentId = studentId;
    this.candidateId = candidateId;
  }

  Long getId() {
    return id;
  }

  Long getStudentId() {
    return studentId;
  }

  Long getCandidateId() {
    return candidateId;
  }
}
