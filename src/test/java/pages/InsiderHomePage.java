package pages;

import org.openqa.selenium.By;

public class InsiderHomePage extends Page {
    private static final By LOGO_INSIDER = By.xpath("//a[@id='logo' and @href='" + BASE_URL + "']");
    private static final String  BASE_MENU_BUTTON_STRING_XPATH = "//a[@href='" + BASE_URL + "%s/'][1]";

    public void clickOnNavMenuButtonWithName(String buttonName) {
        clickOnElement(By.xpath(String.format(BASE_MENU_BUTTON_STRING_XPATH, buttonName)));
    }

}