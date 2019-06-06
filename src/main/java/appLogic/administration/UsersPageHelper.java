package appLogic.administration;

import appLogic.DriverBasedHelper;
import atlasInstances.pages.administration.CreateUserForm;
import atlasInstances.pages.administration.FindUserPanel;
import atlasInstances.pages.administration.UsersListRow;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import testData.UsersAdministrationTestData;
import utils.ApplicationManager;
import utils.Utils;

import java.util.List;
import java.util.Optional;

public class UsersPageHelper extends DriverBasedHelper {

    public UsersPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Check page URL and wait until JS is loaded")
    public UsersPageHelper isUsersPageLoaded() {
        checkUrlAndWaitForJs(UsersAdministrationTestData.URL_USERS_ADMINISTRATION_FULL);
        return this;
    }


    ///////////////////////////////////////Create new user///////////////////////////////////////

    @Step("Click on the create new user button to invoke Create new user dialog")
    public UsersPageHelper openCreateNewUserDialog() {
        pages.administrationPage().getUserPanelContainer().getCreateUserButton().click();
        return this;
    }

    //Fill the XXX field in the Administration -> Users -> Create new user dialog"
    private UsersPageHelper fillCreateNewUserDialogField(String fieldIdentifier, String value) {
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog().getField(fieldIdentifier).sendKeys(value);
        return this;
    }

    @Step("Fill the username in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillLoginField(String loginName) {
        fillCreateNewUserDialogField(CreateUserForm.login, loginName);
        return this;
    }

    @Step("Fill the password in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillPasswordField(String password) {
        fillCreateNewUserDialogField(CreateUserForm.password, password);
        return this;
    }

    @Step("Fill the confirm password in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillConfirmPasswordField(String password) {
        fillCreateNewUserDialogField(CreateUserForm.confirmPassword, password);
        return this;
    }

    @Step("Click on the password change checkbox in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper clickOnTheForcePasswordChangeCheckbox() {
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog().getCheckbox(CreateUserForm.forcePasswordChange).click();
        return this;
    }

    @Step("Fill the full name field in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillFullNameField(String fullName) {
        fillCreateNewUserDialogField(CreateUserForm.fullName, fullName);
        return this;
    }

    @Step("Fill the email in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillEmailField(String fullName) {
        fillCreateNewUserDialogField(CreateUserForm.email, fullName);
        return this;
    }

    @Step("Fill the jabber in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper fillJabberField(String fullName) {
        fillCreateNewUserDialogField(CreateUserForm.jabber, fullName);
        return this;
    }

    @Step("Click on the Ok (confirm user creation button) in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper clickOkButton() {
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog().getButton(CreateUserForm.Ok).click();
        return this;
    }

    ///////////////////////////////////////Find existing user///////////////////////////////////////
    @Step("Fill the find field in the Administration -> Users -> Find section")
    public UsersPageHelper fillFindField(String loginOrEmail) {
        pages.administrationPage().getUserPanelContainer().getFindUserPanelContainer().getField(FindUserPanel.find).sendKeys(loginOrEmail);
        return this;
    }

    @Step("Start user search in the Administration -> Users -> Find section")
    public UsersPageHelper startSearch() {
        pages.administrationPage().getUserPanelContainer().getFindUserPanelContainer().getButton(FindUserPanel.searchButton).click();
        return this;
    }

    ///////////////////////////////////////Users list///////////////////////////////////////
    @Step("Get users list in the Administration -> Users")
    public UsersPageHelper deleteUserWithExactlyTheSameName (String fullMatch) {
        Optional<UsersListRow> rowWithExactSameUser = pages.administrationPage().getUserPanelContainer().getUsersListPanel()
                .getUsersTableRows().stream().filter(row -> row.getColumnFromTheRow(UsersListRow.login).getText().contentEquals(fullMatch)).findFirst();
        if (rowWithExactSameUser.isPresent()) {
            rowWithExactSameUser.get().getColumnFromTheRow(UsersListRow.deleteButton).click();
            Utils.clickOkForAlertPopup(ApplicationManager.getDriverStatic());
        }
        return this;
    }

}
