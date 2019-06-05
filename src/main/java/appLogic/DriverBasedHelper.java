package appLogic;

import org.openqa.selenium.WebDriver;
import utils.ApplicationManager;
import utils.PageManager;
import utils.Utils;

class DriverBasedHelper {


    PageManager pages;
    private WebDriver driver;

    DriverBasedHelper(ApplicationManager manager) {
        this.driver = manager.getDriver();
        pages = new PageManager(driver);
    }

    protected void waitUtilPageLoaded() {
        Utils.waitForJavascriptToLoad(driver);
    }
}
