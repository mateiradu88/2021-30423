package ro.utcluj.model;

public class Student implements Comparable {

  private String name;

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Object object) {
    return 0;
  }

  @Override
  public String getDescription() {
    return null;
  }
}
