package core.conditions.collection;


import org.openqa.selenium.WebElement;

import java.util.List;

import static core.Helpers.getTexts;
import static core.Helpers.listHasExactTexts;

public class ExactTexts extends Texts {

    public ExactTexts(String... texts) {
        super(texts);
    }

    @Override
    public boolean check(List<WebElement> elements) {
        currentTexts = getTexts(elements);
        return listHasExactTexts(currentTexts, texts);
    }
}
