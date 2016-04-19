package core.wrappers;

import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {

    LazyElement get(int index);

    LazyCollection filter(ElementCondition condition);

    LazyElement find(ElementCondition condition);

    LazyCollection should(CollectionCondition... conditions);

    LazyCollection shouldBe(CollectionCondition... conditions);

    LazyCollection shouldHave(CollectionCondition... conditions);
}
