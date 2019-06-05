package appLogic;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ApplicationManager;
import utils.PageManager;
import utils.Utils;

public class DriverBasedHelper {


    PageManager pages;
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
}
