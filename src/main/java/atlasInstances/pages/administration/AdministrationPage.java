package atlasInstances.pages.administration;

import atlasInstances.elements.LeftAdminPanel;
import atlasInstances.elements.Popup;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.UsersAdministrationTestData;

public interface AdministrationPage extends WebPage, Popup, LeftAdminPanel {
    @Description("Search for the User panel container")
    @Retry(timeout = 5000)
    @FindBy(UsersAdministrationTestData.XPATH_USER_PANEL_CONTAINER)
    UserPanel getUserPanelContainer();

}
