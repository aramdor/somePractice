package utils;

import atlasInstances.pages.LoginPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageManager {
    private WebDriver driver;

    private Atlas atlas;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        this.atlas = new Atlas(new WebDriverConfiguration(driver));
        WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    private Logger getLogger() {
        return LoggerFactory.getLogger(PageManager.class);
    }

    protected <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage onLoginPage() {
        return onPage(LoginPage.class);
    }

}
