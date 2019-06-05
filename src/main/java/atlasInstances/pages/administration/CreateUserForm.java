package atlasInstances.pages.administration;

import atlasInstances.elements.DefaultForm;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.UsersAdministrationTestData;

public interface CreateUserForm extends WebPage, DefaultForm {
    String login = "login";
    String password = "password";
    String confirmPassword = "confirmPassword";
    String forcePasswordChange = "forcePasswordChange";
    String fullName = "fullName";
    String email = "email";
    String jabber = "jabber";
    String Ok = "createUserOk";
    String Cancel = "createUserCancel";


    @Description("Search for the Create new user button on the administration -> Users screen")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_CREATE_NEW_USER_BUTTON)
    AtlasWebElement getCreateNewUserButton();
}
