package core.conditions;

import core.conditions.element.*;

public class ElementConditions {

    public static ElementCondition text(final String text) {
        return new Text(text);
    }

    public static ElementCondition exactText(final String text) {
        return new ExactText(text);
    }

    public static ElementCondition visible() {
        return new Visible();
    }

    public static ElementCondition cssClass(final String cssClass) {
        return new CSSClass(cssClass);
    }

    public static ElementCondition present(){return new Present();}
}
