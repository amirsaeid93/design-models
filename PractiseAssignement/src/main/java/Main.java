public class Main {
    public static void main(String [] args) {
        String name = "Spongebob";
        char firstLetter = 'S';
        int age = 30;
        double height = 60.5;
        boolean isEmployed = true;
        System.out.printf("Hello %s.\n", name);
        System.out.printf("Your name starts with a the letter %c.\n", firstLetter);
        System.out.printf("And you are %d years old Spongy.\n", age);
        System.out.printf("And your height is: %.1f cm.\n", height);
        System.out.printf("And your employement status is: %b.", isEmployed);
    }
}
