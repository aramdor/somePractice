package appLogic.administration;

import appLogic.DriverBasedHelper;
import atlasInstances.elements.LeftAdminPanel;
import io.qameta.allure.Step;
import testData.EditUserTestData;
import utils.ApplicationManager;

public class EditUserPageHelper extends DriverBasedHelper {

    public EditUserPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public EditUserPageHelper clickOnUsersLinkInLeftSidebar() {
        pages.administrationPage().getLeftSidebarElement(LeftAdminPanel.users).click();
        return this;
    }

    @Step("Check that edit new user page was opened successfully after the new user was created")
    public EditUserPageHelper wasEditUserPageLoaded() {
        urlContains(EditUserTestData.URL_EDIT_USER_PAGE_BASE_PART);
        return this;
    }
}
