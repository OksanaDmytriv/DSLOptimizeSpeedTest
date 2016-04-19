import org.junit.Test;
import testconfigs.BaseTest;

import static pages.todomvc.ToDoMVC.TaskType.ACTIVE;
import static pages.todomvc.ToDoMVC.TaskType.COMPLETED;
import static pages.todomvc.ToDoMVC.*;

public class TodoMVCTest extends BaseTest {

    @Test
    public void testEdit() {
        givenAtAll(aTask("a", ACTIVE));

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        givenAtAll(aTask("a", ACTIVE));

        startEditing("a", "a edited").pressEscape();
        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testActivateAllOnCompletedFilter() {
        givenAtAll(aTask("a", COMPLETED), aTask("b", COMPLETED));
        filterCompleted();

        toggleAll();
        assertEmptyVisibleTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testTasksCommonFlow() {

        givenAtAll();
        add("a");
        assertVisibleTasks("a");
        toggleAll();

        filterActive();
        assertEmptyVisibleTasks();

        add("b");
        toggle("b");
        assertEmptyVisibleTasks();

        filterCompleted();
        assertVisibleTasks("a", "b");

        //activate task
        toggle("a");
        assertVisibleTasks("b");

        сlearCompleted();
        assertEmptyVisibleTasks();
        assertItemsLeft(1);

        filterAll();
        delete("a");
        assertTasksEmpty();
    }
}
