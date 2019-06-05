package utils;

import atlasInstances.pages.DashboardPage;
import atlasInstances.pages.LoginPage;
import atlasInstances.pages.administration.AdministrationPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;

    private Atlas atlas;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        this.atlas = new Atlas(new WebDriverConfiguration(driver));

    }

    protected <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public LoginPage loginPage() {
        return onPage(LoginPage.class);
    }
    public DashboardPage dashboardPage() {
        return onPage(DashboardPage.class);
    }
    public AdministrationPage administrationPage() { return onPage(AdministrationPage.class); }


}
