public class UIApp {
    public static void main(String[] args) {
        // Choose style A
        Main.UIFactory factory = new Main.AFactory();
        System.out.println("=== Style A ===");
        Main.Button btnA = factory.createButton("OK");
        Main.TextField tfA = factory.createTextField("Enter name");
        Main.Checkbox cbA = factory.createCheckbox("Accept terms");

        btnA.display();
        tfA.display();
        cbA.display();

        // Change text dynamically
        tfA.setText("Changed!");
        tfA.display();

        // Choose style B
        factory = new Main.BFactory();
        System.out.println("\n=== Style B ===");
        Main.Button btnB = factory.createButton("Submit");
        Main.TextField tfB = factory.createTextField("Password");
        Main.Checkbox cbB = factory.createCheckbox("Remember me");

        btnB.display();
        tfB.display();
        cbB.display();

        // Change text dynamically
        btnB.setText("Login");
        btnB.display();
    }
}