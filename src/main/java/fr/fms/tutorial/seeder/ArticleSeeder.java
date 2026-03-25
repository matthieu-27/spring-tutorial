package fr.fms.tutorial.seeder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import fr.fms.tutorial.dao.ArticleRepository;
import fr.fms.tutorial.dao.CategoryRepository;
import fr.fms.tutorial.entities.Article;
import fr.fms.tutorial.entities.Category;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ArticleSeeder implements ApplicationRunner {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (args.getOptionValues("seeder") != null) {
            List<String> seeder = Arrays.asList(args.getOptionValues("seeder").get(0).split(","));
            if (seeder.contains("category")) {
                seedArticles();
                System.out.println("Success run Article seeder");
            }
        } else {
            System.out.println("Article seeder skipped");
        }
    }

    private void seedArticles() {

        // #region
        // Smartphone
        ArrayList<Article> smartphones = new ArrayList<>();
        smartphones.add(new Article("Samsung", "Galaxy S23 Ultra 256 Go", 1299.99));
        smartphones.add(new Article("Apple", "iPhone 15 Pro Max 512 Go", 1599.99));
        smartphones.add(new Article("Google", "Pixel 8 Pro 128 Go", 999.99));
        smartphones.add(new Article("Xiaomi", "Redmi Note 12 Pro+ 5G", 499.99));
        smartphones.add(new Article("OnePlus", "OnePlus 11 256 Go", 899.99));
        smartphones.add(new Article("Sony", "Xperia 1 V 256 Go", 1399.99));
        smartphones.add(new Article("Oppo", "Find X6 Pro 512 Go", 1199.99));
        smartphones.add(new Article("Huawei", "P60 Pro 512 Go", 1099.99));
        smartphones.add(new Article("Motorola", "Edge 40 Pro 256 Go", 799.99));
        smartphones.add(new Article("Nokia", "XR21 128 Go", 599.99));
        smartphones.add(new Article("Asus", "Zenfone 10 256 Go", 749.99));

        // PC
        ArrayList<Article> pcs = new ArrayList<>();
        pcs.add(new Article("Dell", "XPS 15, i7, 16 Go RAM, 1 To SSD", 1999.99));
        pcs.add(new Article("HP", "Pavilion 15, Ryzen 7, 16 Go RAM, 512 Go SSD", 1199.99));
        pcs.add(new Article("Lenovo", "ThinkPad X1 Carbon, i7, 16 Go RAM, 1 To SSD", 1799.99));
        pcs.add(new Article("Apple", "MacBook Pro 14\" M2 Pro, 16 Go RAM, 512 Go SSD", 99.99));
        pcs.add(new Article("Acer", "Swift 3, Ryzen 7, 16 Go RAM, 1 To SSD", 999.99));
        pcs.add(new Article("MSI", "Modern 14, i5, 8 Go RAM, 512 Go SSD", 899.99));
        pcs.add(new Article("Asus", "ROG Zephyrus G14, Ryzen 9, 32 Go RAM, 1 To SSD", 1899.99));
        pcs.add(new Article("Razer", "Blade 15, i7, 16 Go RAM, 1 To SSD", 99.99));
        pcs.add(new Article("Microsoft", "Surface Laptop 5, i7, 16 Go RAM, 512 Go SSD", 1599.99));

        // Tablettes
        ArrayList<Article> tablettes = new ArrayList<>();
        tablettes.add(new Article("Apple", "iPad Pro 12.9\" 256 Go", 1199.99));
        tablettes.add(new Article("Samsung", "Galaxy Tab S9+ 256 Go", 999.99));
        tablettes.add(new Article("Lenovo", "Tab P12 Pro 256 Go", 799.99));
        tablettes.add(new Article("Xiaomi", "Pad 6 Pro 256 Go", 599.99));
        tablettes.add(new Article("Huawei", "MatePad Pro 12.6\" 256 Go", 899.99));
        tablettes.add(new Article("Amazon", "Fire HD 10 Plus 64 Go", 199.99));
        tablettes.add(new Article("Microsoft", "Surface Pro 9, i5, 8 Go RAM, 256 Go SSD", 1099.99));
        tablettes.add(new Article("Sony", "Xperia Tablet Z5 32 Go", 499.99));

        // TV
        ArrayList<Article> tvs = new ArrayList<>();
        tvs.add(new Article("Samsung", "QLED QN90C 65\" 4K", 1799.99));
        tvs.add(new Article("LG", "OLED C3 55\" 4K", 1499.99));
        tvs.add(new Article("Sony", "Bravia XR-65A80L 4K OLED", 2299.99));
        tvs.add(new Article("TCL", "6-Series 65\" 4K QLED", 999.99));
        tvs.add(new Article("Philips", "The One 58\" 4K Ambilight", 799.99));
        tvs.add(new Article("Hisense", "U7K 65\" 4K Mini-LED", 1299.99));
        tvs.add(new Article("Panasonic", "LZ2000 55\" 4K OLED", 1999.99));

        // Son
        ArrayList<Article> son = new ArrayList<>();
        son.add(new Article("Bose", "SoundLink Revolve+ II", 299.99));
        son.add(new Article("Sonos", "Era 300", 449.99));
        son.add(new Article("JBL", "Charge 5", 179.99));
        son.add(new Article("Sony", "WH-1000XM5", 399.99));
        son.add(new Article("Sennheiser", "Momentum 4 Wireless", 349.99));
        son.add(new Article("Bowers & Wilkins", "Px8", 699.99));
        son.add(new Article("Apple", "AirPods Max", 9.99));
        son.add(new Article("Bang & Olufsen", "Beoplay H95", 899.99));

        // Périphériques
        ArrayList<Article> peripheriques = new ArrayList<>();
        peripheriques.add(new Article("Logitech", "MX Master 3S", 99.99));
        peripheriques.add(new Article("Razer", "DeathAdder V3 Pro", 149.99));
        peripheriques.add(new Article("Corsair", "K100 RGB Mechanical Keyboard", 199.99));
        peripheriques.add(new Article("SteelSeries", "Arctis Nova Pro Wireless", 349.99));
        peripheriques.add(new Article("Microsoft", "Xbox Wireless Controller", 59.99));
        peripheriques.add(new Article("Elgato", "Wave:3 Microphone", 159.99));
        peripheriques.add(new Article("Samsung", "T7 Shield 1 To SSD Externe", 99.99));

        // Apple
        ArrayList<Article> apple = new ArrayList<>();
        apple.add(new Article("Apple", "iPhone 15 Pro 128 Go", 999.99));
        apple.add(new Article("Apple", "MacBook Air M2 256 Go", 1199.99));
        apple.add(new Article("Apple", "Apple Watch Series 9", 399.99));
        apple.add(new Article("Apple", "AirPods Pro 2", 249.99));
        apple.add(new Article("Apple", "iPad Air 5 256 Go", 749.99));
        apple.add(new Article("Apple", "HomePod mini", 99.99));
        apple.add(new Article("Apple", "Apple TV 4K", 129.99));

        // Composant
        ArrayList<Article> composants = new ArrayList<>();
        composants.add(new Article("Intel", "Core i9-13900K", 589.99));
        composants.add(new Article("AMD", "Ryzen 9 7950X3D", 649.99));
        composants.add(new Article("NVIDIA", "RTX 4090 24 Go", 1599.99));
        composants.add(new Article("Corsair", "Vengeance RGB 32 Go DDR5", 179.99));
        composants.add(new Article("Samsung", "9 Pro 2 To NVMe SSD", 199.99));
        composants.add(new Article("ASUS", "ROG Strix B650E-F", 249.99));
        composants.add(new Article("Corsair", "RM0x PSU", 149.99));
        composants.add(new Article("Noctua", "NH-D15 CPU Cooler", 99.99));
        // #endregion
        List<List<Article>> artCategories = new ArrayList<>();
        artCategories.add(smartphones);
        artCategories.add(pcs);
        artCategories.add(tablettes);
        artCategories.add(son);
        artCategories.add(tvs);
        artCategories.add(peripheriques);
        artCategories.add(apple);
        artCategories.add(composants);

        List<String> categories = new ArrayList<>();
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
            Category cat = this.categoryRepository.save(new Category(category));
            for (List<Article> listArt : artCategories) {
                for (Article art : listArt) {
                    Article.builder().brand(art.getBrand()).description(art.getDescription()).price(art.getPrice())
                            .category(cat).build();
                    this.articleRepository.save(art);
                }
            }
        }
    }
}
