import atlasInstances.elements.DropDown;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.LoginTestData;
import utils.ApplicationManager;

public class testExecutor {
    private ApplicationManager app;

    @BeforeMethod
    public void driverInit(ITestContext iTestContext) {
        app = new ApplicationManager(iTestContext);
        app.getDriver();
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to create new user")
    public void createNewUser() {

        app.openUrlAndWait(LoginTestData.URL_LOGIN_PAGE);
        app.onLoginPage()
                .inputUsername(LoginTestData.LOGIN_NAME)
                .inputPassword(LoginTestData.PASSWORD)
                .submit();
        app.onDashboardPage()
                .isDashboardPageLoaded()
                .openAdminDropdown()
                .clickOnFieldInAdminDropdown(DropDown.administrationUsers);
        app.onUsersPage()
                .isUsersPageLoaded()
                .openCreateNewUserDialog()
                .fillLoginField("login2")
                .fillPasswordField("password")
                .fillConfirmPasswordField("password")
                .clickOnTheForcePasswordChangeCheckbox()
                .fillFullNameField("Vasiliy Testov")
                .fillEmailField("iaroslav.stepanov@t-systems.com")
                .fillJabberField("123")
                .clickOkButton()
                .editUserPageWasOpened();
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to search for the existing user and delete it if required")
    public void deleteUserWithTheSameName() {

        app.openUrlAndWait(LoginTestData.URL_LOGIN_PAGE);
        app.onLoginPage()
                .inputUsername(LoginTestData.LOGIN_NAME)
                .inputPassword(LoginTestData.PASSWORD)
                .submit();
        app.onDashboardPage()
                .isDashboardPageLoaded()
                .openAdminDropdown()
                .clickOnFieldInAdminDropdown(DropDown.administrationUsers);
        app.onUsersPage()
                .isUsersPageLoaded()
                .fillFindField("login")
                .startSearch()
                .deleteUserWithExactlyTheSameName("login")
        ;
    }

    @AfterMethod
    public void driverStop(ITestContext context) {
        app.stop();
    }
}
