package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.CustomDriverFactory;

public class Hooks {

    @Before
    public void setupDriver() {
        CustomDriverFactory.initializeDriver();
    }

    @After
    public void tearDown() {
        CustomDriverFactory.quit();
    }

}
