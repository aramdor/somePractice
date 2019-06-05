package atlasInstances.elements;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.CommonTestData;

public interface DefaultForm extends AtlasWebElement {
    @Description("Label {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_FIELD_LABEL)
    AtlasWebElement getFieldLabel(@Param("val") String fieldName);

    @Description("Field {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_FIELD)
    AtlasWebElement getField(@Param("val") String fieldName);

    @Description("Checkbox {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_CHECKBOX)
    AtlasWebElement getCheckbox(@Param("val") String fieldName);

    @Description("Button {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(CommonTestData.XPATH_DEFAULT_BUTTON)
    AtlasWebElement getButton(@Param("val") String fieldName);


}
