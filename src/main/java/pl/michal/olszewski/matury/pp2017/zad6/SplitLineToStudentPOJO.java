package pl.michal.olszewski.matury.pp2017.zad6;

public class SplitLineToStudentPOJO {

  public static Student split(String line) {
    String[] split = line.split("\t");
    return new Student(
        Long.valueOf(split[0]),
        split[1], split[2],
        split[3],
        Long.valueOf(split[4].trim()));
  }

}
