package pages.gmail;

import core.wrappers.LazyCollection;
import org.openqa.selenium.By;

import static core.ConciseAPI.$;
import static core.ConciseAPI.byText;
import static core.conditions.CollectionConditions.texts;
import static core.conditions.ElementConditions.text;

public class Mails {

    private static LazyCollection emails = $("[role='main']").findAll(".zA");

    public static void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public static void assertMails(String... subjects) {
        emails.shouldHave(texts(subjects));
    }

    public static void assertMail(int index, String subject) {
        emails.get(index).shouldHave(text(subject));
    }
}
