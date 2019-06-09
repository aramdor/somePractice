package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.CommonTestData;
import testData.DashboardTestData;

public interface TopToolbar extends AtlasWebElement {
    @Description("Search for the administration icon")
    @Retry(timeout = 5000)
    @FindBy(DashboardTestData.XPATH_ADMINISTRATION)
    AtlasWebElement getAdministrationButton();

    @Description("Search for the username dropdown button which contains Profile and Logout links")
    @Retry(timeout = 5000)
    @FindBy(DashboardTestData.XPATH_USER_NAME)
    AtlasWebElement getUserNameButton();

    @Description("Get dropdown window")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_DROPDOWN)
    DropDown getDropdownWindow();
}
