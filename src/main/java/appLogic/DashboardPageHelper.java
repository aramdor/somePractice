package appLogic;

import io.qameta.allure.Step;
import testData.DashboardTestData;
import utils.ApplicationManager;

public class DashboardPageHelper extends DriverBasedHelper {
    public DashboardPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public DashboardPageHelper isDashboardPageLoaded() {
        checkUrlAndWaitForJs(DashboardTestData.URL_DASHBOARD);
        return this;
    }

    @Step("Open administration dropdown")
    public DashboardPageHelper openAdminDropdown() {
        pages.dashboardPage().getTopToolbar().getAdministrationButton().click();
        return this;
    }

    @Step("Click on the element from the dropdown")
    public DashboardPageHelper clickOnFieldInAdminDropdown(String fieldName) {
        pages.dashboardPage().getTopToolbar().getDropdownWindow().getDropdownField(fieldName).click();
        return this;
    }
}
