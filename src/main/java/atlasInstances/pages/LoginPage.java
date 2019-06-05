package atlasInstances.pages;

import atlasInstances.elements.LoginForm;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.LoginPageTestData;

public interface LoginPage extends WebPage {

    @Description("Search for the login page container")
    @Retry(timeout = 5000)
    @FindBy(LoginPageTestData.XPATH_LOGIN_PAGE_CONTAINER)
    LoginForm getLoginPageContainer();
}
