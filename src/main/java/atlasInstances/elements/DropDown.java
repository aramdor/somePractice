package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.CommonTestData;
import testData.UsersAdministrationTestData;

public interface DropDown extends AtlasWebElement {
    String administrationUsers = UsersAdministrationTestData.URL_USERS_ADMINISTRATION_RELATIVE;
    String logOut = UsersAdministrationTestData.URL_USERS_ADMINISTRATION_RELATIVE;

    @Description("Dropdown field {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DROPDOWN_BY_HREF)
    AtlasWebElement getDropdownField(@Param("val") String fieldName);
}
