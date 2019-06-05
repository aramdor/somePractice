package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Utils.class);
    }

    public static boolean waitForJavascriptToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        getLogger().info("Wait for Javascript to load");
        ExpectedCondition<Boolean> jsLoad = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState")
                .toString().equals("complete");
        getLogger().info("Page " + driver.getCurrentUrl() + " is loaded");
        return wait.until(jsLoad);
    }


}
