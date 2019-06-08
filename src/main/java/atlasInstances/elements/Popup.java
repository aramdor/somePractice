package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.CommonTestData;


public interface Popup extends AtlasWebElement, Table {
    @Description("Get popup")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_POPUP)
    Popup getPopupContainer();

    @Description("Get message popup")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_MESSAGE_POPUP)
    Popup getMessagePopupContainer();

    @Description("Get first popup")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_TABLE_ROWS)
    Popup getFirstPopup();

    @Description("Get error description field")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_ERROR_DESCRIPTION)
    AtlasWebElement getErrorDescriptionField();




}
