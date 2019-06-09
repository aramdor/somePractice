package atlasInstances.pages.administration;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.UsersAdministrationTestData;

public interface UserPanel extends WebPage, AtlasWebElement {
    @Description("Search for the Create new user button")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_CREATE_NEW_USER_BUTTON)
    AtlasWebElement getCreateUserButton();


    String createNesUserDialogIsDisplayed = "block";
    String createNesUserDialogIsNotDisplayed = "none";
    @Description("Search for the administration -> Users -> Create new user dialog")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_CREATE_NEW_USER_DIALOG)
    CreateUserForm getCreateNewUserDialog(@Param("val") String displayedOrNot);

    @Description("Get Find user panel container")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_FIND_USER_CONTAINER)
    FindUserPanel getFindUserPanelContainer();

    @Description("Search for the Create new user button")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_USER_LIST)
    UsersListTable getUsersListTable();
}
