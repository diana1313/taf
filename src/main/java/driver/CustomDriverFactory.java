package driver;

import helpers.PropertiesReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CustomDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void initializeDriver() {
        DriverManagerType driverType = DriverManagerType.valueOf(PropertiesReader.getPropertyValue("webdriver.driver"));
        ChromeDriverManager.getInstance(driverType).setup();
        if (driverType.toString().equals("Google Chrome")) {
            driver = new ChromeDriver();
        } else if (driverType.toString().equals("Mozilla Firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new WebDriverManagerException(String.format(
                    "Driver type '%s' defined in properties is not supported", driverType.toString()));
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
