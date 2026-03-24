package fr.fms.tutorial;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.tutorial.dao.ArticleRepository;
import fr.fms.tutorial.dao.CategoryRepository;
import fr.fms.tutorial.entities.Article;
import fr.fms.tutorial.entities.Category;

@SpringBootApplication
public class TutorialApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// #region
		// categoryRepository.save(new Category("Smartphone"));
		// articleRepository.save(new Article("S21", "Samsung", 800));
		// for (Article article : articleRepository.findByBrand("Samsung")) {
		// System.out.println(article);
		// }
		// Category smartphone = categoryRepository.save(new Category("Smartphone"));
		// Category tablet = categoryRepository.save(new Category("Tablettes"));
		// Category pc = categoryRepository.save(new Category("PC"));

		// articleRepository.save(new Article("S10", "Samsung", 500, smartphone));
		// articleRepository.save(new Article("S9", "Samsung", 500, smartphone));
		// articleRepository.save(new Article("MI10", "Xiaomi", 500, smartphone));
		// articleRepository.save(new Article("Galaxy Tab S", "Samsung", 500,tablet));
		// articleRepository.save(new Article("Ipad", "Apple", 1200, tablet));
		// articleRepository.save(new Article("R510", "Asus", 900, pc));
		// #endregion

		// #region
		// trouver 1 moyen d'afficher un article
		Optional<Article> article = articleRepository.findById(Long.valueOf(1));
		article.ifPresent(val -> System.out.println(val));
		// et tout les articles...
		List<Article> articles = articleRepository.findAll();
		printArticles(articles);
		// #endregion

		// #region
		// trouver par telle ou telle marque/description
		List<Article> articleContains = articleRepository.findByBrandContainsAndDescriptionContains("S", "Sam");
		printArticles(articleContains);
		// #endregion

		// #region
		// test de la fonction search
		List<Article> searchArts = articleRepository.findByBrandContainsAndPriceGreaterThan("S10", 200);
		printArticles(searchArts);
		// #endregion

		// #region
		// test du deleteById
		Long id = Long.valueOf(1);
		try {
			articleRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		articles = articleRepository.findAll();
		// on refait le tour pour vérifier
		printArticles(articles);
		// #endregion

		// #region
		Long updateId = Long.valueOf(2);

		try {
			Optional<Article> a = articleRepository.findById(updateId);
			a.ifPresent(val -> {
				val.setBrand("MIMI");
				articleRepository.save(val);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		// #endregion

		// #region
		List<Category> ascList = categoryRepository.findAllByOrderByNameAsc();
		printCategories(ascList);
		List<Category> dscList = categoryRepository.findAllByOrderByNameDesc();
		printCategories(dscList);
		// #endregion

	}

	private void printCategories(List<Category> categories) {
		for (Category c : categories) {
			System.out.println(c);
		}
	}

	private void printArticles(List<Article> articles) {
		for (Article a : articles) {
			System.out.println(a);
		}
	}

}
