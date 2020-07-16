package pages;

import org.openqa.selenium.By;

public class GoogleSearchResultsPage extends Page {
    private final String FACEBOOK_RESULT_XPATH_STRING = "//*[contains(text(),'%s | Facebook')]";

    public boolean isFacebookResultWithUserNameDisplayed(String username) {
        return isElementDisplayed(By.xpath(String.format(FACEBOOK_RESULT_XPATH_STRING, username)));
    }

}
