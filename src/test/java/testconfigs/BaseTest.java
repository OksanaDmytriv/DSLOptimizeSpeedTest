package testconfigs;

import core.ConciseAPI;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    @Before
    public void setUp(){
        ConciseAPI.setDriver(new FirefoxDriver());
    }

    @After
    public void teardown() {
        ConciseAPI.getDriver().quit();
    }
}
