package pl.yellowduck.netflix90.common;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class Person {


  private String firstname;
  private String lastname;
  protected Gender gender;

  public Person(String firstname, String lastname, Gender gender) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
  }

  public Person() {
  }

  public abstract void introduce();

  @Override
  public String toString() {
    return firstname + " " + lastname;
  }
}
