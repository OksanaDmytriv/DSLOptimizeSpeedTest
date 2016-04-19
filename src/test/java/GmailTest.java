import core.Configuration;
import org.junit.Test;
import pages.gmail.Mails;
import pages.gmail.Menu;
import testconfigs.BaseTest;
import testdata.AccountData;

import static core.Helpers.getUniqueText;


public class GmailTest extends BaseTest {

    static {
        Configuration.timeout = 20000;
    }

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        pages.gmail.Gmail.visit();
        pages.gmail.Gmail.login(AccountData.email, AccountData.password);

        Mails.send(AccountData.email, subject);
        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.openSent();
        Mails.assertMail(0, subject);

        Menu.openInbox();
        Menu.search(subject);
        Mails.assertMails(subject);
    }
}

