package atlasInstances.pages.administration;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.UsersAdministrationTestData;

import java.util.List;

public interface UsersListTable extends AtlasWebElement {
    @Description("Get table rows")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_TABLE_ROWS)
    List<UsersListRow> getUsersTableRows();

    @Description("Get \"No users found\" notification")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_NO_USERS_FOUND_NOTIFICATION)
    AtlasWebElement getNoUsersFoundNotification();
}
