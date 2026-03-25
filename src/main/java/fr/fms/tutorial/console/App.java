package fr.fms.tutorial.console;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.fms.tutorial.dao.ArticleRepository;
import fr.fms.tutorial.dao.CategoryRepository;
import fr.fms.tutorial.entities.Article;
import fr.fms.tutorial.entities.Category;

@Component
public class App {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayAllArticles();
                    break;
                case "2":
                    displayArticlesWithPagination();
                    break;
                case "3":
                    addArticle();
                    break;
                case "4":
                    displayArticle();
                    break;
                case "5":
                    deleteArticle();
                    break;
                case "6":
                    updateArticle();
                    break;
                case "7":
                    addCategory();
                    break;
                case "8":
                    displayCategory();
                    break;
                case "9":
                    deleteCategory();
                    break;
                case "10":
                    updateCategory();
                    break;
                case "11":
                    displayArticlesByCategory();
                    break;
                case "12":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void displayArticlesByCategory() {
        System.out.println("Catégories disponibles:");
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            System.out.println(category.getId() + ": " + category.getName());
        }
        System.out.print("ID de la catégorie: ");
        Long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        List<Article> articles = articleRepository.findByCategoryId(categoryId);
        printArticles(articles);
    }

    private void updateCategory() {
        System.out.print("ID de la catégorie: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            System.out.print("Nouveau nom (" + category.getName() + "): ");
            String name = scanner.nextLine();

            category.setName(name.isEmpty() ? category.getName() : name);

            categoryRepository.save(category);
            System.out.println("Catégorie mise à jour avec succès.");
        } else {
            System.out.println("Catégorie introuvable.");
        }
    }

    private void deleteCategory() {
        System.out.print("ID de la catégorie: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        try {
            categoryRepository.deleteById(id);
            System.out.println("Catégorie supprimée avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression: " + e.getMessage());
        }
    }

    private void displayCategory() {
        System.out.print("ID de la catégorie: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            System.out.println(categoryOpt.get());
        } else {
            System.out.println("Catégorie introuvable.");
        }
    }

    private void addCategory() {
        System.out.print("Nom de la catégorie: ");
        String name = scanner.nextLine();

        Category category = new Category(name);
        categoryRepository.save(category);
        System.out.println("Catégorie ajoutée avec succès.");
    }

    private void updateArticle() {
        System.out.print("ID de l'article: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            System.out.print("Nouvelle marque (" + article.getBrand() + "): ");
            String brand = scanner.nextLine();
            System.out.print("Nouvelle description (" + article.getDescription() + "): ");
            String description = scanner.nextLine();
            System.out.print("Nouveau prix (" + article.getPrice() + "): ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            article.setBrand(brand.isEmpty() ? article.getBrand() : brand);
            article.setDescription(description.isEmpty() ? article.getDescription() : description);
            article.setPrice(price == 0 ? article.getPrice() : price);

            articleRepository.save(article);
            System.out.println("Article mis à jour avec succès.");
        } else {
            System.out.println("Article introuvable.");
        }
    }

    private void deleteArticle() {
        System.out.print("ID de l'article: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        try {
            articleRepository.deleteById(id);
            System.out.println("Article supprimé avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression: " + e.getMessage());
        }
    }

    private void displayArticle() {
        System.out.print("ID de l'article: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            System.out.println(articleOpt.get());
        } else {
            System.out.println("Article introuvable.");
        }
    }

    private void addArticle() {
        System.out.print("Marque: ");
        String brand = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Prix: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Catégories disponibles:");
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            System.out.println(category.getId() + ": " + category.getName());
        }
        System.out.print("ID de la catégorie: ");
        Long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
        if (categoryOpt.isPresent()) {
            Article article = new Article(brand, description, price, categoryOpt.get());
            articleRepository.save(article);
            System.out.println("Article ajouté avec succès.");
        } else {
            System.out.println("Catégorie introuvable.");
        }
    }

    private void displayArticlesWithPagination() {
        int pageSize = 5;
        int pageNumber = 0;
        boolean inPagination = true;

        while (inPagination) {
            List<Article> articles = articleRepository.findAll();
            int totalPages = (int) Math.ceil((double) articles.size() / pageSize);

            int start = pageNumber * pageSize;
            int end = Math.min(start + pageSize, articles.size());
            List<Article> pageArticles = articles.subList(start, end);

            printArticles(pageArticles);

            System.out.print("\n");
            if (pageNumber > 0) {
                System.out.print("PREV ");
            }
            for (int i = 0; i < totalPages; i++) {
                if (i == pageNumber) {
                    System.out.print("[" + i + "] ");
                } else {
                    System.out.print(i + " ");
                }
            }
            if (pageNumber < totalPages - 1) {
                System.out.print("NEXT");
            }
            System.out.print("\n\n");
            System.out.print(
                    "Tapez MENU pour revenir au menu principal, PREV/NEXT pour naviguer, ou PAGE X pour changer la taille de la page: ");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("MENU")) {
                inPagination = false;
            } else if (input.equalsIgnoreCase("PREV") && pageNumber > 0) {
                pageNumber--;
            } else if (input.equalsIgnoreCase("NEXT") && pageNumber < totalPages - 1) {
                pageNumber++;
            } else if (input.startsWith("PAGE")) {
                try {
                    pageSize = Integer.parseInt(input.split(" ")[1]);
                } catch (Exception e) {
                    System.out.println("Format invalide. Utilisez PAGE X où X est un nombre.");
                }
            } else {
                System.out.println("Commande invalide.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nBienvenu dans notre application de gestion d'articles !");
        System.out.println("1: Afficher tous les articles sans pagination");
        System.out.println("2: Afficher tous les articles avec pagination");
        System.out.println("3: Ajouter un article");
        System.out.println("4: Afficher un article");
        System.out.println("5: Supprimer un article");
        System.out.println("6: Modifier un article");
        System.out.println("7: Ajouter une categorie");
        System.out.println("8: Afficher une categorie");
        System.out.println("9: Supprimer une categorie");
        System.out.println("10: Mettre a jour une categorie");
        System.out.println("11: Afficher tous les articles d'une categorie");
        System.out.println("12: Sortir du programme");
        System.out.print("Votre choix: ");
    }

    private void displayAllArticles() {
        List<Article> articles = articleRepository.findAll();
        printArticles(articles);
    }

    private void printArticles(List<Article> articles) {
        if (articles.isEmpty()) {
            System.out.println("Aucun article trouvé.");
            return;
        }

        System.out.println("\n");
        System.out.printf("%-10s %-60s %-30s %-20s %-30s\n", "ID", "DESCRIPTION", "MARQUE", "PRIX", "CATEGORIE");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Article article : articles) {
            String categoryName = article.getCategory() != null ? article.getCategory().getName() : "Aucune";
            System.out.printf("\"%-10s %-60s %-30s %-20s %-30s\n",
                    article.getId(),
                    article.getDescription(),
                    article.getBrand(),
                    article.getPrice(),
                    categoryName);
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
