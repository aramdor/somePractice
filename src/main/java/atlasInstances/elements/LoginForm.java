package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.LoginPageTestData;

public interface LoginForm extends AtlasWebElement {
    String login = "login";
    String password = "password";

    @Description("Field {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(LoginPageTestData.XPATH_GET_FIELD)
    AtlasWebElement getField(@Param("val") String fieldName);

    @Description("Field {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(LoginPageTestData.XPATH_GET_BUTTON)
    AtlasWebElement getButton(@Param("val") String fieldName);
}
