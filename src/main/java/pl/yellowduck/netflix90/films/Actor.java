package pl.yellowduck.netflix90.films;

import lombok.Getter;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.common.Person;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "actor")
public class Actor extends Person {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)

  private Integer id;

  public Actor (String firstname,
              String lastname,
               Gender gender) {
    super(firstname, lastname, gender);
  }

  public Actor() {
  }

  @Override
  public void introduce() {
    // like this
//    if(Gender.MALE.equals(gender)) {
//      System.out.println("My name is " + firstname + " " + lastname + ". I am actor.");
//    } else {
//      System.out.println("My name is " + firstname + " " + lastname + ". I am actress.");
//    }

    switch (this.gender) {
      case MALE:
        System.out.println("My name is " + getFirstname() + " " + getLastname() + ". I am actor.");
        break;
      case FEMALE:
        System.out.println("My name is " + getFirstname() + " " + getLastname() + ". I am actress.");
        break;
    }
  }

  @Override
  public String toString() {
    return "Actor: " + getFirstname() + " " + getLastname();
  }
}
