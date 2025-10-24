import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestLocal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Locale locale = selectLanguage(sc);
        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", locale);

        try {

            System.out.println(messages.getString("prompt_items_number"));
            int numberOfItems = sc.nextInt();
            double totalCost = 0.0;


            for (int i = 1; i <= numberOfItems; i++) {
                System.out.printf(messages.getString("prompt_item_price") + " %d:%n", i);
                double itemPrice = sc.nextDouble();


                System.out.printf(messages.getString("prompt_item_quantity") + " %d:%n", i);
                int itemQuantity = sc.nextInt();


                totalCost += (itemPrice * itemQuantity);
            }


            System.out.printf("%s %.2f%n", messages.getString("total_cost"), totalCost);

        } catch (InputMismatchException e) {

            System.out.println(messages.getString("error_invalid_input"));
        } finally {
            sc.close();
        }
    }


    private static Locale selectLanguage(Scanner sc) {
        System.out.print("\nSelect the language you want to use by choosing a number from 1-4: ");
        System.out.println("1. English (US)");
        System.out.println("2. Suomi (FI)");
        System.out.println("3. Svenska (SE)");
        System.out.println("4. 日本語 (JP)");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 2:
                return new Locale("fi", "FI");
            case 3:
                return new Locale("sv", "SE");
            case 4:
                return new Locale("ja", "JP");
            case 1:
            default:
                return new Locale("en", "US");
        }
    }
}
