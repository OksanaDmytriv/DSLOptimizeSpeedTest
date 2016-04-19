package pages.gmail;

import org.openqa.selenium.By;

import static core.ConciseAPI.$;

public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void openSent() {
        $(By.linkText("Sent Mail")).click();
    }

    public static void openInbox() {
        $("a[aria-label^='Inbox']").click();
    }

    public static void search(String subject) {
        $(By.name("q")).setValue("subject:" + subject).pressEnter();
    }
}
