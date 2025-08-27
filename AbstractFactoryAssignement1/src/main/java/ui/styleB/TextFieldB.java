package ui.styleB;

import ui.abstracts.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("/" + "-".repeat(text.length() + 2) + "\\");
        System.out.println("| " + text + " |");
        System.out.println("\\" + "-".repeat(text.length() + 2) + "/");
    }
}