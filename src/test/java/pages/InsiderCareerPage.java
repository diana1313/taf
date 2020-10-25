package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InsiderCareerPage extends InsiderHomePage {
    private static final String BASE_BUTTON_STRING_XPATH = "//a[@href='#%s']";
    private static final String BASE_FILTER_OPTION_STRING_XPATH = "//option[text()='%s']";
    private static final By FILTER_JOBS_BY_LOCATION_XPATH = By.xpath("//select[@class='jobs-locations']");
    private static final By FILTER_JOBS_BY_TEAMS_XPATH = By.xpath("//select[@class='jobs-teams']");
    private static final By JOB_LIST_ITEMS_XPATH = By.xpath("//div[@class='jobs-list']/a");


    public void clickOnButtonWithName(String buttonName) {
        clickOnElement(By.xpath(String.format(BASE_BUTTON_STRING_XPATH, buttonName)));
    }

    public void selectOptionInFilter(String filter, String option) {
        if ("by location".equalsIgnoreCase(filter)) {
            clickOnElement(FILTER_JOBS_BY_LOCATION_XPATH);
        } else {
            clickOnElement(FILTER_JOBS_BY_TEAMS_XPATH);
        }
        clickOnElement(By.xpath(String.format(BASE_FILTER_OPTION_STRING_XPATH, option)));
    }

    public List<WebElement> getJobListItems() {
        return driver.findElements(JOB_LIST_ITEMS_XPATH);
    }

    public String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(String.format("data-%s", attributeName.toLowerCase()));
        //data-location, data-team
    }
}
