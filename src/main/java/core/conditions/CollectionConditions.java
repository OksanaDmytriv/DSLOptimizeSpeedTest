package core.conditions;

import core.conditions.collection.ExactTexts;
import core.conditions.collection.MinimumSize;
import core.conditions.collection.Size;
import core.conditions.collection.Texts;

public class CollectionConditions {
    public static CollectionCondition texts(final String... texts) {
        return new Texts(texts);
    }

    public static CollectionCondition exactTexts(final String... texts) {
        return new ExactTexts(texts);
    }

    public static CollectionCondition size(final int expectedSize) {
        return new Size(expectedSize);
    }

    public static CollectionCondition minimumSize(final int minimumSize) {
        return new MinimumSize(minimumSize);
    }

    public static CollectionCondition empty() {
        return new Size(0);
    }

}
