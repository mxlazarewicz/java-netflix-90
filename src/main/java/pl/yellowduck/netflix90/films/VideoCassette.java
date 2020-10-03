package pl.yellowduck.netflix90.films;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "VideoCasette")
public class VideoCassette {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private BigDecimal price;

  private String title;

  private Director director;

  private Category category;

  private Set<Actor> actors;

  public VideoCassette() {
  }

  public VideoCassette(BigDecimal price, String title, Director director, Category category, Set<Actor> actors) {
    this.price = price;
    this.title = title;
    this.director = director;
    this.category = category;
    this.actors = actors;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<Actor> getActors() {
    return actors;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
  }
}
