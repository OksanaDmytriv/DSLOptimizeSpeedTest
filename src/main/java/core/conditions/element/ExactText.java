package core.conditions.element;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    public boolean checkElement() {
        return currentText.equals(text);
    }
}
