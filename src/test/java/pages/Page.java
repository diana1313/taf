package pages;

import driver.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page implements BasePage {

    protected WebDriver driver = ChromeDriverFactory.getDriver();

    @Override
    public void open(String url) {
        driver.get(url);
    }

    public void clickOnElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();

    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public void sendKeysIntoField(By element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(text);
    }

    public String getElementText(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }


    public boolean isElementDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

    @Override
    public void initElements() {
        PageFactory.initElements(driver, this);
    }
}
