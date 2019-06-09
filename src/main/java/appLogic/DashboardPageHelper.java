package appLogic;

import io.qameta.allure.Step;
import testData.DashboardTestData;
import testData.UserObject;
import utils.ApplicationManager;

public class DashboardPageHelper extends PageWithTopToolbarHelper {
    public DashboardPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public DashboardPageHelper isPageLoaded() {
        checkUrlAndWaitForJs(DashboardTestData.URL_DASHBOARD);
        return this;
    }

    public DashboardPageHelper openAdminDropdown() {
        super.openAdminDropdown();
        return this;
    }

    public DashboardPageHelper openUserNameDropdown() {
        super.openUserNameDropdown();
        return this;
    }

    public DashboardPageHelper clickOnFieldInDropdown(String fieldName) {
        super.clickOnFieldInDropdown(fieldName);
        return this;
    }

    public DashboardPageHelper checkUserName (UserObject user) {
        super.checkCurrentUserName(user);
        return this;
    }


}
