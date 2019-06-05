package utils;

import appLogic.LoginPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import ru.stqa.selenium.factory.WebDriverPool;
import utils.listeners.TestListener;
import webDriver.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private ApplicationProperties appProperties = new ApplicationProperties();
    private EventFiringWebDriver firingWebDriver;
    private ITestContext iTestContext;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private LoginPageHelper loginPageHelper;

    private Logger getLogger() {
        return LoggerFactory.getLogger(ApplicationManager.class);
    }


    ////////////////////////////////////////
    public void printAppProperties() {
        System.out.println(appProperties.toString());
    }
    ////////////////////////////////////////

    public ApplicationManager(ITestContext iTestContext) {
        this.iTestContext = iTestContext;
        loginPageHelper = new LoginPageHelper(this);
    }

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            DesiredCapabilities capabilities = Capabilities.getCapabilities(appProperties);
                getLogger().info("Starting web driver");
            WebDriver driver = null;
            try {
                driver = WebDriverPool.DEFAULT.getDriver(new URL(appProperties.hub), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            webDriver.set(driver);
            Assert.assertNotNull(webDriver.get(), "Error whiled configuring driver");
            webDriver.get().manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            firingWebDriver = new EventFiringWebDriver(webDriver.get());
        }
        setUpTestContextAttributes(iTestContext);
        return webDriver.get();
    }

    public static WebDriver getDriverStatic() {
        return webDriver.get();
    }

    public void stop() {
        getLogger().info("Stop the browser");
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }

    private void setUpTestContextAttributes(ITestContext iTestContext) {
        iTestContext.setAttribute("driver", webDriver.get());
    }

    public void openApplicationUrl() {
        webDriver.get().get(appProperties.getApplicationUri());
        Utils.waitForJavascriptToLoad(webDriver.get());
    }

    public LoginPageHelper getLoginPageHelper() {
        return loginPageHelper;
    }


}
