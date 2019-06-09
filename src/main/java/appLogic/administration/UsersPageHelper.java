package appLogic.administration;

import appLogic.DriverBasedHelper;
import atlasInstances.pages.administration.CreateUserForm;
import atlasInstances.pages.administration.FindUserPanel;
import atlasInstances.pages.administration.UserPanel;
import atlasInstances.pages.administration.UsersListRow;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testData.EditUserTestData;
import testData.LoginTestData;
import testData.UserObject;
import testData.UsersAdministrationTestData;
import utils.ApplicationManager;
import utils.Utils;

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

    @Step("Make sure that we are able to create new user. If no let's delete all users")
    public UsersPageHelper deleteAllUsersIfUserLimitIsExceeded() {
        if (pages.administrationPage().getUserPanelContainer().getUsersListTable().getAmountOfUsers().getText().trim().contentEquals("(11 total)")) {
            int k = pages.administrationPage().getUserPanelContainer().getUsersListTable().getAllElementsFromTheUsersTable(UsersListRow.deleteButton).size() - 1; //-1 is added because we are not able to delete guest user but it has delete button
            for (int i = 0; i < k; i++) {
                Optional<UsersListRow> userToDelete = pages.administrationPage().getUserPanelContainer().getUsersListTable().getTableRows().stream().filter(user -> {
                    String currentName = user.getColumnFromTheRow(UsersListRow.login).getText();
                    return !currentName.contentEquals("guest") &&
                            !currentName.contentEquals(LoginTestData.LOGIN_NAME) &&
                            !currentName.contentEquals("root");
                }).findFirst();
                if (userToDelete.isPresent()) {
                    userToDelete.get().getColumnFromTheRow(UsersListRow.deleteButton).click();
                    Utils.clickOkForAlertPopup(ApplicationManager.getDriverStatic());
                }
            }
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
        getCreateNewUserDialogField(fieldIdentifier).sendKeys(value);
        return this;
    }

    private AtlasWebElement getCreateNewUserDialogField(String fieldIdentifier) {
        return pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsDisplayed).getField(fieldIdentifier);
    }

    @Step("Check that all fields of the Administration -> Users -> Create new user dialog are empty")
    public UsersPageHelper areCreateNewUserDialogFieldsEmpty() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.login).getText().trim(), "", "Login field is NOT empty!");
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.password).getText().trim(), "", "Password field is NOT empty!");
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.confirmPassword).getText().trim(), "", "Password confirmation field is NOT empty!");
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.fullName).getText().trim(), "", "Full name field is NOT empty!");
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.email).getText().trim(), "", "Email field is NOT empty!");
        softAssert.assertEquals( getCreateNewUserDialogField(CreateUserForm.jabber).getText().trim(), "", "Jabber field is NOT empty!");
        softAssert.assertAll();
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
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsDisplayed).getCheckbox(CreateUserForm.forcePasswordChange).click();
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
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsDisplayed).getButton(CreateUserForm.Ok).click();
        return this;
    }

    @Step("Click on the Cancel (reject user creation button) in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper clickCancelButton() {
        pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsDisplayed).getButton(CreateUserForm.Cancel).click();
        return this;
    }
    //^^^Fill the XXX field in the Administration -> Users -> Create new user dialog"^^^

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

    @Step("Check that message popup appears")
    public UsersPageHelper isCreateNewUserDialogDisplayed(Boolean expectedResult) {
        if (expectedResult) {
            try {
                pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsDisplayed).isDisplayed();
            } catch (NoSuchElementException ex) {
                Assert.fail("Seems to be that create new user dialog was NOT opened!");
            }
        } else {
            try {
                pages.administrationPage().getUserPanelContainer().getCreateNewUserDialog(UserPanel.createNesUserDialogIsNotDisplayed).getTagName();
            } catch (NoSuchElementException ex) {
                Assert.fail("Seems to be that create new user dialog was NOT closed!");
            }
        }
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
    public UsersPageHelper doesUserAlreadyExistsWithAssert(String loginName, Boolean expectedResult) {
        if ((expectedResult && doesUserAlreadyExists(loginName)) || (!expectedResult && !doesUserAlreadyExists(loginName))) {
            return this;
        }
            else {
            Assert.fail("It is expected that user: " + loginName + " does exists = " + expectedResult + ". But it does not!" );
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

    @Step("Fill the username in the Administration -> Users -> Create new user dialog")
    public UsersPageHelper checkExistingUserFieldsAccordingToTestData(UserObject userData) {
        Optional<UsersListRow> user = getRowByExactlyTheSameLogin(userData.getLogin()); //TODO add checks for all fields
        if (user.isPresent()) {
            if (userData.getFullName() != null) {
                Assert.assertEquals(user.get().getFullNameOrEmailFieldFromTheRow(userData.getFullName()).getText().trim(), userData.getFullName(), "Full name did not match");
            }
            if (userData.getEmail() != null) {
                Assert.assertEquals(user.get().getFullNameOrEmailFieldFromTheRow(userData.getEmail()).getText().trim(), userData.getEmail(), "Email did not match");
            }
            if (userData.getJabber() != null) {
                Assert.assertEquals(user.get().getFullNameOrEmailFieldFromTheRow(userData.getJabber()).getText().trim(), userData.getJabber(), "Jabber did not match");
            }
            Assert.assertEquals(user.get().getLastAccess().getText().trim(), userData.getLastAccess(), "Last access field did not match");
            try {
                Assert.assertTrue(user.get().getAllUsersGroupLink().isDisplayed(), "All users default group was NOT added");
                Assert.assertTrue(user.get().getNewUsersGroupLink().isDisplayed(), "New users default group was NOT added");
            } catch (NoSuchElementException ex) {
                Assert.fail("Default groups were NOT added");
            }
        } else {
            Assert.fail("User was not found!");
        }
        return this;
    }

    ////////////////////////////////Shortcuts////////////////////////////////
    @Step("Create new user if it does not exist (Administration -> Users page)")
    public UsersPageHelper createUserIfItDoesNotExists(ApplicationManager app, UserObject user) {
        if (!doesUserAlreadyExists(user.getLogin())) {
            app.onUsersPage()
                    .isUsersPageLoaded()
                    .openCreateNewUserDialog()
                    .fillCreateUserDialogFieldsAccordingToTestData(app, user)
                    .clickOkButton();
            app.onEditUserPage()
                    .wasEditUserPageLoaded()
                    .clickOnUsersLinkInLeftSidebar();
            app.onUsersPage()
                    .isUsersPageLoaded();
            doesUserAlreadyExistsWithAssert(user.getLogin(), true);
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
