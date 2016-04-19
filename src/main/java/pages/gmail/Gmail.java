package pages.gmail;

import org.openqa.selenium.Keys;

import static core.ConciseAPI.*;

public class Gmail {

    public static void login(String email, String password) {
        $("#Email").sendKeys(email + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);
    }

    public static void visit() {
        open("http://gmail.com");
    }
}
