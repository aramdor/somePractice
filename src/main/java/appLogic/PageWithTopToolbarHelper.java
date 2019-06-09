package appLogic;

import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.testng.Assert;
import testData.UserObject;
import utils.ApplicationManager;

public class PageWithTopToolbarHelper extends DriverBasedHelper{

    public PageWithTopToolbarHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Open administration dropdown")
    public PageWithTopToolbarHelper openAdminDropdown() {
        pages.dashboardPage().getTopToolbar().getAdministrationButton().click();
        return this;
    }

    @Step("Open username dropdown with Profile and Log out links")
    public PageWithTopToolbarHelper openUserNameDropdown() {
        pages.dashboardPage().getTopToolbar().getUserNameButton().click();
        return this;
    }

    @Step("Check user name in the top toolbar")
    public PageWithTopToolbarHelper checkCurrentUserName(UserObject user) {
        String expectedName;
        String assertText;
        if (user.getFullName() != null)
        {
            expectedName = user.getFullName();
            assertText = "User full name did not match!";
        }
        else {
            expectedName = user.login;
            assertText = "User login name did not match!";
        }
        Assert.assertEquals(pages.dashboardPage().getTopToolbar().getUserNameButton().getText().trim(), expectedName, assertText);
        return this;
    }

    @Step("Click on the element from the dropdown")
    public PageWithTopToolbarHelper clickOnFieldInDropdown(String fieldName) {
        getDropdownField(fieldName).click();
        return this;
    }

    private AtlasWebElement getDropdownField(String fieldName) {
        return pages.dashboardPage().getTopToolbar().getDropdownWindow().getDropdownField(fieldName);
    }
}
