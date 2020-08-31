package mdriver;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.java.picocontainer.PicoFactory;
import lombok.extern.java.Log;

import static helpers.PropertiesReader.getPropertyValue;

@Log
public class DriverFactory implements ObjectFactory {

    private final PicoFactory delegate = new PicoFactory();

    public DriverFactory() {
        switch (getPropertyValue("browser")) {
            case "chrome":
                addClass(CustomChromeDriver.class);
                log.info("Chrome driver is running.");
               break;
            case "firefox":
                addClass(CustomFireFoxDriver.class);
                log.info("Firefox driver is not implement yet.");
                break;
            default:
                log.info("No driver is running.");
        }
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}
