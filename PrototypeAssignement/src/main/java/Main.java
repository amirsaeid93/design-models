import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String, Recommendation> recommendations = new HashMap<>();

        Recommendation fictionLovers = new Recommendation("Fiction Lovers");
        fictionLovers.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));
        fictionLovers.addBook(new Book("J.R.R. Tolkien", "The Hobbit", "Fantasy", 1937));
        recommendations.put(fictionLovers.getTargetAudience(), fictionLovers);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View all recommendations");
            System.out.println("2. Clone a recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- All Recommendations ---");
                    recommendations.forEach((key, value) -> System.out.println(value));
                    break;
                case 2:
                    System.out.print("Enter the target audience of the recommendation to clone: ");
                    String audienceToClone = scanner.nextLine();
                    if (recommendations.containsKey(audienceToClone)) {
                        Recommendation original = recommendations.get(audienceToClone);
                        Recommendation cloned = original.clone();
                        System.out.print("Enter the new target audience for the cloned list: ");
                        String newAudience = scanner.nextLine();
                        cloned.setTargetAudience(newAudience);
                        recommendations.put(newAudience, cloned);
                        System.out.println("Cloned successfully!");
                    } else {
                        System.out.println("Recommendation not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
