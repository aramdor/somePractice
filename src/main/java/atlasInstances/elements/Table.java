package atlasInstances.elements;

import atlasInstances.pages.administration.UsersListRow;
import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import testData.CommonTestData;

import java.util.List;

public interface Table extends AtlasWebElement {
    @Description("Get table rows")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_TABLE_ROWS)
    List<UsersListRow> getTableRows();
}
