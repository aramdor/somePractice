package appLogic.administration;

import appLogic.PageWithTopToolbarHelper;
import atlasInstances.elements.LeftAdminPanel;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import testData.CommonTestData;
import testData.EditUserTestData;
import utils.ApplicationManager;

public class EditUserPageHelper extends PageWithTopToolbarHelper {

    public EditUserPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Open Users Administration page via the Left side bar")
    public EditUserPageHelper clickOnUsersLinkInLeftSidebar() {
        pages.administrationPage().getLeftSidebarElement(LeftAdminPanel.users).click();
        return this;
    }

    @Step("Check that edit new user page was opened successfully after the new user was created")
    public EditUserPageHelper wasEditUserPageLoaded() {
        urlContains(EditUserTestData.URL_EDIT_USER_PAGE_BASE_PART);
        try {
            Assert.assertTrue(pages.administrationPage().getEditUserPanelContainer().isDisplayed(), "Edit user panel is NOT displayed!!");
        } catch (NoSuchElementException ex) {
            Assert.fail("Edit user panel is NOT displayed!!");
        }
        return this;
    }

    public EditUserPageHelper openUserNameDropdown() {
        super.openUserNameDropdown();
        return this;
    }

    public EditUserPageHelper clickOnFieldInDropdown(String fieldName) {
        super.clickOnFieldInDropdown(fieldName);
        return this;
    }
}
