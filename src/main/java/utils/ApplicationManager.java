package utils;

import appLogic.DashboardPageHelper;
import appLogic.DriverBasedHelper;
import appLogic.LoginPageHelper;
import appLogic.administration.UsersPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import ru.stqa.selenium.factory.WebDriverPool;
import webDriver.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private EventFiringWebDriver firingWebDriver;
    private ITestContext iTestContext;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    ///////////////////////////////////vvvv Initialize page helpers here vvvv///////////////////////////////////
    private LoginPageHelper loginPageHelper;
    private DashboardPageHelper dashboardPageHelper;
    private UsersPageHelper usersPageHelper;

    public LoginPageHelper onLoginPage() {
        return loginPageHelper;
    }
    public DashboardPageHelper onDashboardPage() { return dashboardPageHelper; }
    public UsersPageHelper onUsersPage() { return usersPageHelper; }

    public ApplicationManager(ITestContext iTestContext) {
        this.iTestContext = iTestContext;
        loginPageHelper = new LoginPageHelper(this);
        dashboardPageHelper = new DashboardPageHelper(this);
        usersPageHelper = new UsersPageHelper(this);
    }


    //AN=nd do not forget to initialize in Page Manager!! utils.PageManager
    ///////////////////////////////////^^^^Initialize page helpers here^^^^///////////////////////////////////



    private Logger getLogger() {
        return LoggerFactory.getLogger(ApplicationManager.class);
    }

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            DesiredCapabilities capabilities = Capabilities.getCapabilities();
                getLogger().info("Starting web driver");
            WebDriver driver = null;
            try {
                driver = WebDriverPool.DEFAULT.getDriver(new URL(ApplicationProperties.hub), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            webDriver.set(driver);
            Assert.assertNotNull(webDriver.get(), "Error whiled configuring driver");
            webDriver.get().manage().window().maximize();
            assert driver != null;
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

    public void openUrlAndWait(String url) {
        new DriverBasedHelper(this).openUrlAndWaitForJs(url);
    }




}
