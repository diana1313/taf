package mdriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver extends Driver {

    private static final String CHROME_DRIVER_FILES_PATH = "src/test/resources/driver/chromedriver";

    public CustomChromeDriver() {
        initializeDriver();
    }

    @Override
    protected void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILES_PATH);
        setDriver(new ChromeDriver());
    }
}
