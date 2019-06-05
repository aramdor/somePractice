package appLogic;

import atlasInstances.elements.LoginForm;
import io.qameta.allure.Step;
import utils.ApplicationManager;

public class LoginPageHelper extends DriverBasedHelper {

    public LoginPageHelper(ApplicationManager app) {
        super(app);
    }

    @Step("Find a field and input username")
    public LoginPageHelper inputUsername(String username) {
        pages.loginPage().getLoginPageContainer().getField(LoginForm.login).clear();
        pages.loginPage().getLoginPageContainer().getField(LoginForm.login).sendKeys(username);
        return this;
    }

    @Step("Find a field and input password")
    public LoginPageHelper inputPassword(String password) {
        pages.loginPage().getLoginPageContainer().getField(LoginForm.password).clear();
        pages.loginPage().getLoginPageContainer().getField(LoginForm.password).sendKeys(password);
        return this;
    }

    @Step("Find login button and click on it")
    public LoginPageHelper submit() {
        pages.loginPage().getLoginPageContainer().getButton(LoginForm.login).click();
        return this;
    }
}
