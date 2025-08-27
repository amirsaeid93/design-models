public class Main {

    abstract static class UIElement {
        protected String text;

        public UIElement(String text) {
            this.text = text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public abstract void display();
    }

    abstract static class Button extends UIElement {
        public Button(String text) {
            super(text);
        }
    }

    abstract static class TextField extends UIElement {
        public TextField(String text) {
            super(text);
        }
    }

    abstract static class Checkbox extends UIElement {
        public Checkbox(String text) {
            super(text);
        }
    }


    static class ButtonA extends Button {
        public ButtonA(String text) {
            super(text);
        }

        @Override
        public void display() {
            System.out.println("[" + text + "]");
        }
    }

    static class TextFieldA extends TextField {
        public TextFieldA(String text) {
            super(text);
        }

        @Override
        public void display() {
            System.out.println("| " + text + " |");
        }
    }

    static class CheckboxA extends Checkbox {
        public CheckboxA(String text) {
            super(text);
        }

        @Override
        public void display() {
            System.out.println("( ) " + text);
        }
    }


    static class ButtonB extends Button {
        public ButtonB(String text) {
            super(text);
        }

        @Override
        public void display() {
            System.out.println("+---- " + text + " ----+");
        }
    }

    static class TextFieldB extends TextField {
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

    static class CheckboxB extends Checkbox {
        public CheckboxB(String text) {
            super(text);
        }

        @Override
        public void display() {
            System.out.println("[ ] " + text);
        }
    }


    abstract static class UIFactory {
        public abstract Button createButton(String text);

        public abstract TextField createTextField(String text);

        public abstract Checkbox createCheckbox(String text);
    }


    static class AFactory extends UIFactory {
        @Override
        public Button createButton(String text) {
            return new ButtonA(text);
        }

        @Override
        public TextField createTextField(String text) {
            return new TextFieldA(text);
        }

        @Override
        public Checkbox createCheckbox(String text) {
            return new CheckboxA(text);
        }
    }

    static class BFactory extends UIFactory {
        @Override
        public Button createButton(String text) {
            return new ButtonB(text);
        }

        @Override
        public TextField createTextField(String text) {
            return new TextFieldB(text);
        }

        @Override
        public Checkbox createCheckbox(String text) {
            return new CheckboxB(text);
        }
    }
}