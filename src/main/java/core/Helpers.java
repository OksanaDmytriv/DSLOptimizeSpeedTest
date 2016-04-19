package core;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static String getUniqueText(String prefix) {
        return (prefix + " " + System.currentTimeMillis());
    }

    public static List<String> getTexts(List<WebElement> elements) {
        List<String> currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        return currentTexts;
    }

    public static boolean listHasTexts(final List<String> currentTexts, final String...
            expectedTexts) {
        if (currentTexts.size() != expectedTexts.length) {
            return false;
        }
        for (int i = 0; i < expectedTexts.length; ++i) {
            if (!currentTexts.get(i).contains(expectedTexts[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean listHasExactTexts(List<String> currentTexts, final String...
            expectedTexts) {
        if (currentTexts.size() != expectedTexts.length) {
            return false;
        }
        for (int i = 0; i < expectedTexts.length; ++i) {
            if (!currentTexts.get(i).equals(expectedTexts[i])) {
                return false;
            }
        }
        return true;
    }
}
