package atlasInstances.pages.administration;

import atlasInstances.elements.Table;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.UsersAdministrationTestData;


public interface UsersListTable extends AtlasWebElement, Table {

    @Description("Get \"No users found\" notification")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_NO_USERS_FOUND_NOTIFICATION)
    AtlasWebElement getNoUsersFoundNotification();
}
