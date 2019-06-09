package appLogic;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import testData.CommonTestData;
import testData.UserProfileTestData;
import utils.ApplicationManager;

public class UserProfilePageHelper extends PageWithTopToolbarHelper{

    public UserProfilePageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public UserProfilePageHelper isPageLoaded() {
        checkUrlAndWaitForJs(UserProfileTestData.URL_USER_PROFILE_PAGE);
        return this;
    }

    ////////////////////////////////Change password////////////////////////////////
    @Step("Is change password dialog displayed")
    public UserProfilePageHelper isChangePasswordDialogDisplayed(Boolean isDisplayed) {
        if (isDisplayed) {
            try {
                pages.userProfilePage().getUsersProfileContainer().getChangePasswordDialog(CommonTestData.dialogIsShown).getText();
            } catch (NoSuchElementException ex) {
                Assert.fail("User profile -> change password dialog is NOT shown!");
            }
        } else {
            try {
                pages.userProfilePage().getUsersProfileContainer().getChangePasswordDialog(CommonTestData.dialogIsNotShown).getText();
            } catch (NoSuchElementException ex) {
                Assert.fail("Seems to be that User profile -> change password dialog is shown. But it is NOT expected");
            }
        }
        return this;
    }
    ////////////////////////////////^^^ Change password ^^^////////////////////////////////
}
