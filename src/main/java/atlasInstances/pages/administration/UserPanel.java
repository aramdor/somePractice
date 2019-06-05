package atlasInstances.pages.administration;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.UsersAdministrationTestData;

public interface UserPanel extends WebPage {
    @Description("Search for the Create new user button")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_CREATE_NEW_USER_BUTTON)
    AtlasWebElement getCreateNewUserButton();

    @Description("Search for the administration -> Users -> Create new user dialog")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_CREATE_NEW_USER_DIALOG)
    CreateUserForm getCreateNewUserDialog();
}
