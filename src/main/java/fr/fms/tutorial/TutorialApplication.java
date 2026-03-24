package fr.fms.tutorial;

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
		// categoryRepository.save(new Category("Smartphone"));
		// articleRepository.save(new Article("S21", "Samsung", 800));
		// for (Article article : articleRepository.findByBrand("Samsung")) {
		// System.out.println(article);
		// }
		Category smartphone = categoryRepository.save(new Category("Smartphone"));
		Category tablet = categoryRepository.save(new Category("Tablettes"));
		Category pc = categoryRepository.save(new Category("PC"));

		articleRepository.save(new Article("S10", "Samsung", 500, smartphone));
		articleRepository.save(new Article("S9", "Samsung", 500, smartphone));
		articleRepository.save(new Article("MI10", "Xiaomi", 500, smartphone));
		articleRepository.save(new Article("Galaxy Tab S", "Samsung", 500, tablet));
		articleRepository.save(new Article("Ipad", "Apple", 1200, tablet));
		articleRepository.save(new Article("R510", "Asus", 900, pc));
	}

}
