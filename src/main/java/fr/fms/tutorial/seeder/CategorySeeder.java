package fr.fms.tutorial.seeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import fr.fms.tutorial.dao.CategoryRepository;
import fr.fms.tutorial.entities.Category;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CategorySeeder implements ApplicationRunner {
    private final CategoryRepository categoryRepository;

    private static final Logger log = LoggerFactory.getLogger(CategorySeeder.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.getOptionValues("seeder") != null) {
            List<String> seeder = Arrays.asList(args.getOptionValues("seeder").get(0).split(","));
            if (seeder.contains("category")) {
                seedCategories();
                System.out.println("Success run Category seeder");
            }
        } else {
            System.out.println("Category seeder skipped");
        }
    }

    private void seedCategories() {
        List<String> categories = new ArrayList();
        categories.add("Smartphone");
        categories.add("PC");
        categories.add("Tablettes");
        categories.add("Smartphone");
        categories.add("TV");
        categories.add("Son");
        categories.add("Périphériques");
        categories.add("Apple");
        categories.add("Composant");
        for (String category : categories) {
            Category.builder().name(category).build();
            this.categoryRepository.save(new Category(category));
        }
    }

}
