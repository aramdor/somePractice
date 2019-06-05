import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.LoginPageTestData;
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
    @Description("Debug method to execute some code")
    public void executor() {

        app.openApplicationUrl();
        app.getLoginPageHelper()
                .inputUsername(LoginPageTestData.LOGIN_NAME)
                .inputPassword(LoginPageTestData.PASSWORD)
                .submit();
    }

    @AfterMethod
    public void driverStop(ITestContext context) {
        app.stop();
    }
}
