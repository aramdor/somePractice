package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.AdministrationPageCommonTestData;

public interface LeftAdminPanel extends WebPage {
    String projects = "Project list";
    String users = "User list";
    String groups = "Group list";
    String roles = "Role list";
    String issueLinkTypes = "Issue Link Types";

    @Description("Get {{ val }} from the left sidebar")
    @Retry(timeout = 5000)
    @FindBy(AdministrationPageCommonTestData.XPATH_LEFT_SIDEBAR_ELEMENT)
    AtlasWebElement getLeftSidebarElement(@Param("val") String fieldName);
}
