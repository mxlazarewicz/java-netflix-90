package pl.yellowduck.netflix90.films;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  private String name;
  private String description;

  private Category() {
  }

  public Category(String name, String description) {
    //this.id = id;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return name;
  }
}