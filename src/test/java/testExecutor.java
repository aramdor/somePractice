import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.ApplicationManager;

public class testExecutor {

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to execute some code")
    public void executor(ITestContext iTestContext) {
        ApplicationManager app = new ApplicationManager(iTestContext);
        app.printAppProperties();
        app.getDriver();
        app.openApplicationUrl();
        app.stop();
    }
}
