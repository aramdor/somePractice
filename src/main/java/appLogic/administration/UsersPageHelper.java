package appLogic.administration;

import appLogic.DriverBasedHelper;
import atlasInstances.pages.administration.CreateUserForm;
import atlasInstances.pages.administration.FindUserPanel;
import atlasInstances.pages.administration.UsersListRow;
import io.qameta.allure.Step;
import org.testng.Assert;
import testData.EditUserTestData;
import testData.UserObject;
import testData.UsersAdministrationTestData;
import utils.ApplicationManager;
import utils.Utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Step("Make sure that we are able to create new user. If no let's delete all users")
    public UsersPageHelper deleteAllUsersIfUserLimitIsExceeded() {
        if (pages.administrationPage().getUserPanelContainer().getUsersListTable().getAmountOfUsers().getText().trim().contentEquals("(11 total)")) {
            pages.administrationPage().getUserPanelContainer().getUsersListTable().getAllElementsFromTheUsersTable(UsersListRow.deleteButton)
                    .forEach(user -> {
                        pages.administrationPage().getUserPanelContainer().getUsersListTable().getAllElementsFromTheUsersTable(UsersListRow.deleteButton).get(0).click();
                        Utils.clickOkForAlertPopup(ApplicationManager.getDriverStatic());
                        if (!isMessagePopupDisplayed()) //TODO: does not work!! reimplement
                        {
                            pages.administrationPage().getUserPanelContainer().getUsersListTable().getAllElementsFromTheUsersTable(UsersListRow.deleteButton).get(1).click();
                            Utils.clickOkForAlertPopup(ApplicationManager.getDriverStatic());
                        }
                    });
            Assert.assertTrue(pages.administrationPage().getUserPanelContainer().getCreateUserButton().isDisplayed(), "Create new user button is still not displayed!!");
        }
        return this;
    }

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

    @Step("Check that edit new user page was opened successfully after the new user was created")
    public void wasEditUserPageOpened() {
        urlContains(EditUserTestData.URL_EDIT_USER_PAGE_BASE_PART);
    }

    @Step("Check \"Value should be unique\' popup")
    public void checkPopupError() {
        System.out.println(
                pages.administrationPage().getPopupContainer().getFirstPopup().getErrorDescriptionField().getText()
        );
    }

    @Step("Check that message popup appears")
    public Boolean isMessagePopupDisplayed() {
        return pages.administrationPage().getPopupContainer().getMessagePopupContainer().isDisplayed();
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
    public UsersPageHelper deleteUserWithExactlyTheSameLogin(String fullMatch) {
        isUsersListTableEmpty();
        Optional<UsersListRow> usersListRow = getRowByExactlyTheSameLogin(fullMatch);
        if (usersListRow.isPresent()) {
            usersListRow.get().getColumnFromTheRow(UsersListRow.deleteButton).click();
            Utils.clickOkForAlertPopup(ApplicationManager.getDriverStatic());
        }
        isUsersPageLoaded();
        return this;
    }

    @Step("Check that user with the same login present in the users list table in the (Administration -> Users page)")
    public UsersPageHelper doesUserAlreadyExistsWithAssert(String fullMatch) {
        if (!doesUserAlreadyExists(fullMatch)) {
            Assert.fail("User with login: " + fullMatch + " does not exists");
        }
        return this;
    }

    @Step("Check that user with the same login present in the users list table in the (Administration -> Users page)")
    public Boolean doesUserAlreadyExists(String fullMatch) {
        isUsersListTableEmpty();
        Optional<UsersListRow> usersListRow = getRowByExactlyTheSameLogin(fullMatch);
        return usersListRow.isPresent();
    }

    @Step("Check that user search returns some values")
    private UsersPageHelper isUsersListTableEmpty() {
        try {
            pages
                    .administrationPage()
                    .getUserPanelContainer()
                    .getUsersListTable()
                    .getTableRows().get(0).isDisplayed();
        } catch (IndexOutOfBoundsException ex) {
            Assert.fail("Users list table is empty!");
        }
        return this;
    }

    @Step("Find user with exactly the same login, name or email")
    private Optional<UsersListRow> getRowByExactlyTheSameLogin(String fullMatch) {
        return pages.administrationPage().getUserPanelContainer().getUsersListTable()
                .getTableRows().stream().filter(row -> row.getColumnFromTheRow(UsersListRow.login).getText().contentEquals(fullMatch)).findFirst();
    }

    ////////////////////////////////Shortcuts////////////////////////////////
    @Step("Create new user if it does not exist (Administration -> Users page)")
    public UsersPageHelper createUserIfItDoesNotExists(ApplicationManager app, UserObject user) {
        if (!doesUserAlreadyExists(user.getLogin())) {
            app.onUsersPage()
                    .isUsersPageLoaded()
                    .openCreateNewUserDialog()
                    .fillLoginField(user.getLogin())
                    .fillPasswordField(user.getPassword())
                    .fillConfirmPasswordField(user.getPasswordConfirmation())
                    .clickOnTheForcePasswordChangeCheckbox()
                    .fillFullNameField(user.getFullName())
                    .fillEmailField(user.getEmail())
                    .fillJabberField(user.getJabber())
                    .clickOkButton();
            app.onEditUserPage()
                    .wasEditUserPageLoaded()
                    .clickOnUsersLinkInLeftSidebar();
            app.onUsersPage()
                    .isUsersPageLoaded();
            doesUserAlreadyExistsWithAssert(user.getLogin());
            return this;
        } else {
            return this;
        }
    }

    @Step("Create new user based on existing test date (Administration -> Users page)")
    public UsersPageHelper fillCreateUserDialogFieldsAccordingToTestData(ApplicationManager app, UserObject user) {
        if (user.getLogin() != null) {
            app.onUsersPage().fillLoginField(user.getLogin());
        }
        if (user.getPassword() != null) {
            app.onUsersPage().fillPasswordField(user.getPassword());
        }
        if (user.getPasswordConfirmation() != null) {
            app.onUsersPage().fillConfirmPasswordField(user.getPasswordConfirmation());
        }
        if (user.getForcePasswordChangeCheckbox() != null) {
            if (user.getForcePasswordChangeCheckbox()) {
                app.onUsersPage().clickOnTheForcePasswordChangeCheckbox();
            }
        }
        if (user.getFullName() != null) {
            app.onUsersPage().fillFullNameField(user.getFullName());
        }
        if (user.getEmail() != null) {
            app.onUsersPage().fillEmailField(user.getEmail());
        }
        if (user.getJabber() != null) {
            app.onUsersPage().fillJabberField(user.getJabber());
        }
        return this;
    }
}
