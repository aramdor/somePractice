package appLogic;

import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ApplicationManager;
import utils.PageManager;
import utils.Utils;

public class DriverBasedHelper {


    public PageManager pages;
    private WebDriver driver;

    public DriverBasedHelper(ApplicationManager manager) {
        this.driver = manager.getDriver();
        pages = new PageManager(driver);
    }

    @Step
    public void openUrlAndWaitForJs(String url) {
        driver.get(url);
        checkUrlAndWaitForJs(url);
    }

    @Step
    protected void checkUrlAndWaitForJs(String url) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.urlToBe(url));
        Utils.waitForJavascriptToLoad(driver);
    }

    @Step
    protected void urlContains(String url) {
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.urlContains(url));
            Utils.waitForJavascriptToLoad(driver);
        }
        catch (TimeoutException ex) {
            Assert.fail("Url mismatch! Expected is: " + url + "but actual is " +driver.getCurrentUrl());
        }
    }
}
