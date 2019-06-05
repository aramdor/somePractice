package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.LoginTestData;

public interface LoginForm extends AtlasWebElement, DefaultForm {
    String login = "login";
    String password = "password";

    @Description("Button {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(LoginTestData.XPATH_LOGIN_BUTTON)
    AtlasWebElement getLoginButton(@Param("val") String fieldName);
}
