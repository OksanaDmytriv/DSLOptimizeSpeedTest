package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static core.Helpers.getTexts;
import static core.Helpers.listHasTexts;

public class Texts extends CollectionCondition {

    public List<String> currentTexts;
    public final String[] texts;

    public Texts(String... texts) {
        if (texts.length == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        this.texts = texts;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        currentTexts = getTexts(elements);
        return listHasTexts(currentTexts, texts);
    }

    @Override
    public String actual() {
        return Arrays.toString(currentTexts.toArray());
    }

    @Override
    public String expected() {
        return Arrays.toString(texts);
    }
}
