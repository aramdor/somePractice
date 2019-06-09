package atlasInstances.pages.user;

import io.qameta.allure.Description;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import testData.UserProfileTestData;

public interface UserProfilePage extends WebPage, AtlasWebElement {
    @Description("Get password change dialog. Expected display condition is {{ val }}")
    @Retry(timeout = 5000)
    @FindBy(UserProfileTestData.XPATH_CHANGE_PASSWORD_DIALOG)
    AtlasWebElement getChangePasswordDialog(@Param("val") String displayedOrNot);



    @Description("Get user profile container")
    @Retry(timeout = 5000)
    @FindBy(UserProfileTestData.XPATH_USER_PROFILE_CONTAINER)
    UserProfilePage getUsersProfileContainer();
}
