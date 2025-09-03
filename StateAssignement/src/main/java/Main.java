import character.GameCharacter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        GameCharacter character = new GameCharacter(name);

        while (!(character.getState().getLevelName().equals("Master"))) {
            System.out.println("\n" + character.getStatus());
            System.out.println("Choose an action: train | meditate | fight | quit");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train" -> character.train();
                case "meditate" -> character.meditate();
                case "fight" -> character.fight();
                case "quit" -> {
                    System.out.println("Game ended.");
                    return;
                }
                default -> System.out.println("Invalid action!");
            }
        }

        System.out.println("\n🎉 Congratulations! " + character.getStatus());
        System.out.println("Game Over.");
    }
}