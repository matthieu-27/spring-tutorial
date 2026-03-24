package fr.fms.tutorial.dao;

import fr.fms.tutorial.entities.Article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    public List<Article> findByBrand(String brand);

    public List<Article> findByBrandContains(String brand);

    public List<Article> findByBrandAndPrice(String brand, double price);

    public List<Article> findByBrandContainsAndDescriptionContains(String brand, String description);

    public List<Article> findByBrandContainsAndPriceGreaterThan(String brand, double price);

}
