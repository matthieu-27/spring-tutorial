package fr.fms.tutorial.console;

import java.util.List;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    private void deleteCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

    private void displayCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayCategory'");
    }

    private void addCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCategory'");
    }

    private void updateArticle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateArticle'");
    }

    private void deleteArticle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteArticle'");
    }

    private void displayArticle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayArticle'");
    }

    private void addArticle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addArticle'");
    }

    private void displayArticlesWithPagination() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayArticlesWithPagination'");
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
        System.out.printf("%-10s %-20s %-20s %-10s %-20s\n", "ID", "DESCRIPTION", "MARQUE", "PRIX", "CATEGORIE");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        for (Article article : articles) {
            String categoryName = article.getCategory() != null ? article.getCategory().getName() : "Aucune";
            System.out.printf("%-10d %-20s %-20s %-10.2f %-20s\n",
                    article.getId(),
                    article.getDescription(),
                    article.getBrand(),
                    article.getPrice(),
                    categoryName);
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
    }
}
