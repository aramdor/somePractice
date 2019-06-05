package webDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.ApplicationProperties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.remote.BrowserType.*;

public class Capabilities {
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Capabilities.class);
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities;
        //set browser
        switch (ApplicationProperties.browserName) {
            case FIREFOX: {
                capabilities = getFirefoxCapabilities();
                break;
            }
            case CHROME:
            default: {
                capabilities = getChromeCapabilities();
                break;
            }
        }
//        //Is used only when you need to specify exact device
//        if (capabilities != null) {
//            //set application name if it is specified
//            if (ApplicationProperties.deviceName != null && !ApplicationProperties.deviceName.equals("")) {
//                capabilities.setCapability("applicationName", ApplicationProperties.deviceName);
//            }
//        } else {
        if (capabilities == null) {
            getLogger().error("Error while configuring capabilities for browser " + ApplicationProperties.browserName);
            System.exit(1);
        }
        return capabilities;
    }

    private static DesiredCapabilities getFirefoxCapabilities() {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");


        DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
        FirefoxProfile profile = new FirefoxProfile();
        firefoxCapabilities.setBrowserName("firefox");
        firefoxCapabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return firefoxCapabilities;
    }

    private static DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");

        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return chromeCapabilities;
    }

}
