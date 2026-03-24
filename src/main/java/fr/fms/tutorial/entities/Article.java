package fr.fms.tutorial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String brand;
  private String description;
  private double price;

  @ManyToOne
  private Category category;

  public Article() {
  }

  public Article(String brand, String description, double price, Category category) {
    this.brand = brand;
    this.description = description;
    this.price = price;
    this.category = category;
  }

  public Article(String brand, String description, double price) {
    this.brand = brand;
    this.description = description;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Article [id=" + this.id + ", description=" + this.description + ", brand=" + this.brand + ", price="
        + this.price + "]";
  }

  public long getId() {
    return this.id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String value) {
    this.brand = value;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String value) {
    this.description = value;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double value) {
    this.price = value;
  }
}