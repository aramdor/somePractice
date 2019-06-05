package appLogic.administration;

import appLogic.DriverBasedHelper;
import atlasInstances.pages.administration.CreateUserForm;
import io.qameta.allure.Step;
import testData.UsersAdministrationTestData;
import utils.ApplicationManager;

public class UsersPageHelper extends DriverBasedHelper {

    public UsersPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public UsersPageHelper isUsersPageLoaded() {
        checkUrlAndWaitForJs(UsersAdministrationTestData.URL_USERS_ADMINISTRATION_FULL);
        return this;
    }

    @Step("Click on the create new user button to invoke Create new user dialog")
    public UsersPageHelper openCreateNewUserDialog() {
        pages.administrationPage().getUserPanelContainer().getCreateNewUserButton().click();
        return this;
    }

    //Fill the XXX field in the Administration -> Users -> Create new user dialog"
    private UsersPageHelper fillField(String fieldIdentifier, String value) {
        pages.administrationPage().getUserPanelContainer().getField(fieldIdentifier).sendKeys(value);
        return this;
    }

    @Step("Fill the username in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillLoginField(String loginName) {
        fillField(CreateUserForm.login, loginName);
        return this;
    }

    @Step("Fill the password in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillPasswordField(String password) {
        fillField(CreateUserForm.password, password);
        return this;
    }

    @Step("Fill the confirm password in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillConfirmPasswordField(String password) {
        fillField(CreateUserForm.confirmPassword, password);
        return this;
    }

    @Step("Click on the password change checkbox in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper clickOnTheForcePasswordChangeCheckbox() {
        pages.administrationPage().getUserPanelContainer().getCheckbox(CreateUserForm.forcePasswordChange).click();
        return this;
    }

    @Step("Fill the full name field in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillFullNameField(String fullName) {
        fillField(CreateUserForm.fullName, fullName);
        return this;
    }

    @Step("Fill the email in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillEmailField(String fullName) {
        fillField(CreateUserForm.email, fullName);
        return this;
    }

    @Step("Fill the jabber in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillJabberField(String fullName) {
        fillField(CreateUserForm.jabber, fullName);
        return this;
    }



}
