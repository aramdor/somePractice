package atlasInstances.pages.administration;

import atlasInstances.elements.Table;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.UsersAdministrationTestData;

import java.util.List;


public interface UsersListTable extends AtlasWebElement, Table {

    @Description("Get \"No users found\" notification")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_NO_USERS_FOUND_NOTIFICATION)
    AtlasWebElement getNoUsersFoundNotification();

    @Description("Get amount of users")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_AMOUNT_OF_USERS)
    AtlasWebElement getAmountOfUsers();

    @Description("Get all {{ val }} elements for the users table")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_COLUMN_FROM_THE_ROW)
    List<AtlasWebElement> getAllElementsFromTheUsersTable(@Param("val") String fieldName);
}
