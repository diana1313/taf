package mdriver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public abstract class Driver {
    @Getter
    @Setter
    private WebDriver driver;

    protected abstract void initializeDriver();

}
