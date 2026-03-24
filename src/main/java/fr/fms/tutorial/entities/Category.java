package fr.fms.tutorial.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "category")
  private Collection<Article> articles;

  @Override
  public String toString() {
    return this.name;
  }

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long value) {
    this.id = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }
}
