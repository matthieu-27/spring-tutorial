package fr.fms.tutorial.dao;

import fr.fms.tutorial.entities.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAllByOrderByNameAsc();

    public List<Category> findAllByOrderByNameDesc();

}
