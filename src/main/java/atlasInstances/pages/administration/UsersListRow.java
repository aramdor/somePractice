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

    @Description("Search for the user login column value")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_COLUMN_FROM_THE_ROW)
    AtlasWebElement getColumnFromTheRow(@Param("val") String fieldName);
}
