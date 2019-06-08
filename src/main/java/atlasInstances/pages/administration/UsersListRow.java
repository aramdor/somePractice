package atlasInstances.pages.administration;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.UsersAdministrationTestData;

public interface UsersListRow extends AtlasWebElement {
    String login = "usersList.UserLogin";
    String deleteButton = "usersList.deleteUser";

    @Description("Search for the user {{ val }} column value") //applicable for the login and delete fields only!
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_COLUMN_FROM_THE_ROW)
    AtlasWebElement getColumnFromTheRow(@Param("val") String fieldName);

    @Description("Search for the user {{ val }} column value") //applicable for the full name, Email/Jabber	field only! Param should be taken from the UserObject!!
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_COLUMN_FROM_THE_ROW_BY_TITLE)
    AtlasWebElement getFullNameOrEmailFieldFromTheRow(@Param("val") String fieldName);

    @Description("Search for the Last access field")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_LAST_ACCESS_COLUMN)
    AtlasWebElement getLastAccess();

    @Description("Search for the All users default group link")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_ALL_USERS_GROUP_LINK)
    AtlasWebElement getAllUsersGroupLink();

    @Description("Search for the New users default group link")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_NEW_USERS_GROUP_LINK)
    AtlasWebElement getNewUsersGroupLink();
}
