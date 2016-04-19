package pages.todomvc;

import core.wrappers.LazyCollection;
import core.wrappers.LazyElement;
import ru.yandex.qatools.allure.annotations.Step;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.empty;
import static core.conditions.CollectionConditions.exactTexts;
import static core.conditions.ElementConditions.*;
import static pages.todomvc.ToDoMVC.TaskType.ACTIVE;

public class ToDoMVC {

    private static LazyCollection tasks = $("#todo-list").findAll("li");

    @Step
    public static void add(String... taskTexts) {
        for (String text : taskTexts) {
            $("#new-todo").setValue(text).pressEnter();
        }
    }

    @Step
    public static void assertItemsLeft(int number) {
        $("#todo-count>strong").shouldHave(exactText(Integer.toString(number)));
    }

    @Step
    public static void сlearCompleted() {
        $("#clear-completed").click();
    }

    @Step
    public static void toggle(String taskText) {
        tasks.find(exactText(taskText)).find(".toggle").click();
    }

    @Step
    public static void toggleAll() {
        $("#toggle-all").click();
    }

    @Step
    public static LazyElement startEditing(String oldText, String newText) {
        tasks.find(exactText(oldText)).find("label").doubleClick();
        return tasks.find(cssClass("editing")).find(".edit").setValue(newText);
    }

    @Step
    public static void filterAll() {
        $("[href='#/']").click();
    }

    @Step
    public static void filterActive() {
        $("[href='#/active']").click();
    }

    @Step
    public static void filterCompleted() {
        $("[href='#/completed']").click();
    }

    @Step
    public static void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().find(".destroy").click();
    }

    @Step
    public static void assertTasks(String... taskTexts) {
        tasks.shouldHave(exactTexts(taskTexts));
    }

    @Step
    public static void assertTasksEmpty() {
        tasks.shouldBe(empty());
    }

    @Step
    public static void assertVisibleTasks(String... taskTexts) {
        tasks.filter(visible()).shouldHave(exactTexts(taskTexts));
    }

    @Step
    public static void assertEmptyVisibleTasks() {
        tasks.filter(visible()).shouldBe(empty());
    }

    public static enum TaskType {
        ACTIVE, COMPLETED;
    }

    public static class Task {
        String text;
        TaskType type;

        public Task(String text, TaskType type) {
            this.text = text;
            this.type = type;
        }
    }

    public static Task aTask(String text, TaskType type) {
        Task task = new Task(text, type);
        return task;
    }

    @Step
    public static String toJSON(Task task) {
        return "{\"completed\":" + ((ACTIVE == task.type) ? false : true) + ", \"title\":\"" + task.text + "\"},";
    }

    public static void ensureOpenedToDoMVC() {
        if (!getDriver().getCurrentUrl().equals("https://todomvc4tasj.herokuapp.com/"))
            open("https://todomvc4tasj.herokuapp.com/");
    }

    private static void givenHelper(Task... tasks) {
        ensureOpenedToDoMVC();
        String js = "localStorage.setItem('todos-troopjs', '[";
        for (Task task : tasks) {
            js += toJSON(task);
        }
        if (tasks.length > 0) {
            js = js.substring(0, (js.length() - 1));
        }
        js += "]');";
        executeJavaScript(js);
        getDriver().navigate().refresh();
    }

    @Step
    public static void givenAtAll() {
        givenHelper();
    }

    @Step
    public static void givenAtAll(String... taskTexts) {
        Task[] tasksArray = new Task[taskTexts.length];
        for (int i = 0; i < taskTexts.length; i++) {
            tasksArray[i] = aTask(taskTexts[i], ACTIVE);
        }
        givenHelper(tasksArray);
    }

    @Step
    public static void givenAtAll(Task... tasks) {
        givenHelper(tasks);
    }

    @Step
    public static void givenAtActive(Task... tasks) {
        givenHelper(tasks);
        filterActive();
    }

    @Step
    public static void givenAtCompleted(Task... tasks) {
        givenHelper(tasks);
        filterCompleted();
    }

    @Step
    public static void givenAtActive(String... taskTexts) {
        givenAtAll(taskTexts);
        filterActive();
    }
}