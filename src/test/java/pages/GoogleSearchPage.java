package pages;

import driver.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchPage extends Page {
    public static final String BASE_URL = "https://www.google.com";
    private static final By SEARCH_BAR_NAME = By.name("q");

    public void enterQueryToSearchBar(String query) {
        sendKeysIntoField(SEARCH_BAR_NAME, query + Keys.ENTER);
    }
}
