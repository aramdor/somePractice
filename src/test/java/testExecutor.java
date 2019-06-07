import atlasInstances.elements.DropDown;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.LoginTestData;
import testData.UserObject;
import utils.ApplicationManager;

public class testExecutor {
    private ApplicationManager app;
    private UserObject baseUser = new UserObject("login", "password", "password", true, "Vasiliy Testov", "iaroslav.stepanov@t-systems.com", "123");

    ///////////////////////////////Before and after actions///////////////////////////////

    @BeforeMethod
    public void driverInit(ITestContext iTestContext) {
        app = new ApplicationManager(iTestContext);
        app.getDriver();

        app.openUrlAndWait(LoginTestData.URL_LOGIN_PAGE);
        app.onLoginPage()
                .inputUsername(LoginTestData.LOGIN_NAME)
                .inputPassword(LoginTestData.PASSWORD)
                .submit();
        app.onDashboardPage()
                .isDashboardPageLoaded()
                .openAdminDropdown()
                .clickOnFieldInAdminDropdown(DropDown.administrationUsers);
    }

    @AfterMethod
    public void driverStop(ITestContext context) {
        app.stop();
    }

    ///////////////////////////////Test cases///////////////////////////////

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to create new user")
    public void createNewUser() {
        UserObject currentUser = baseUser;

        app.onUsersPage()
                .isUsersPageLoaded()
                .doesUserAlreadyExistsWithAssert(currentUser.getLogin())
                .openCreateNewUserDialog()
                .fillLoginField(currentUser.getLogin())
                .fillPasswordField(currentUser.getPassword())
                .fillConfirmPasswordField(currentUser.getPasswordConfirmation())
                .clickOnTheForcePasswordChangeCheckbox()
                .fillFullNameField(currentUser.getFullName())
                .fillEmailField(currentUser.getEmail())
                .fillJabberField(currentUser.getJabber())
                .clickOkButton();
        app.onEditUserPage()
                .wasEditUserPageLoaded();
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to search for the existing user and delete it if required")
    public void deleteUserWithTheSameName() {
        UserObject currentUser = baseUser;

        app.onUsersPage()
                .isUsersPageLoaded()
                .fillFindField(currentUser.getLogin())
                .startSearch()
                .deleteUserWithExactlyTheSameName(currentUser.getLogin())
        ;
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Check that we are not able to create new user with existing login name")
    public void createNewUserWithExistingLoginName() {
        UserObject currentUser = baseUser;
        currentUser.setLogin("login22");

        app.onUsersPage()
                .isUsersPageLoaded()
                .createUserIfItDoesNotExists(app, currentUser)
                .openCreateNewUserDialog()
                .fillLoginField(currentUser.getLogin())
                .fillPasswordField(currentUser.getPassword())
                .fillConfirmPasswordField(currentUser.getPasswordConfirmation())
                .clickOnTheForcePasswordChangeCheckbox()
                .fillFullNameField(currentUser.getFullName())
                .fillEmailField(currentUser.getEmail())
                .fillJabberField(currentUser.getJabber())
                .clickOkButton()
                .checkPopupError();
    }


}
