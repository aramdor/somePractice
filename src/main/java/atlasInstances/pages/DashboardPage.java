package atlasInstances.pages;

import atlasInstances.elements.TopToolbar;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.CommonTestData;

public interface DashboardPage extends WebPage {
    @Description("Search for the top toolbar (Issues, Agile Boards, Reports, etc.)")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_TOP_TOOLBAR)
    TopToolbar getTopToolbar();
}
