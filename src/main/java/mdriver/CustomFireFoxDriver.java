package mdriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomFireFoxDriver extends Driver {

    private static final String FIREFOX_DRIVER_FILES_PATH = "src/test/resources/driver/geckodriver";

    public CustomFireFoxDriver() {
        initializeDriver();
    }

    @Override
    protected void initializeDriver() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_FILES_PATH);
        setDriver(new FirefoxDriver());
    }
}
