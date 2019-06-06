package testData;

import utils.ApplicationProperties;

public class LoginTestData {
    public static final String URL_LOGIN_PAGE = ApplicationProperties.applicationUri + "/login";

    public static final String LOGIN_NAME = ApplicationProperties.username;
    public static final String PASSWORD = ApplicationProperties.password;

    /////////////////////////XPATHS/////////////////////////
   public static final String XPATH_LOGIN_PAGE_CONTAINER = "//*[@class = 'loginPageContainer']//form[contains(@id,'loginForm')]";
    public static final String XPATH_LOGIN_BUTTON = ".//input[contains(@id,'{{ val }}') and (@type='submit')]";

}
