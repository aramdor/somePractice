package testData;

public class LoginPageTestData {
    public static final String LOGIN_NAME = "root";
    public static final String PASSWORD = "121382";

    /////////////////////////XPATHS/////////////////////////
   public static final String XPATH_LOGIN_PAGE_CONTAINER = "//*[@class = 'loginPageContainer']//form[contains(@id,'loginForm')]";
   public static final String XPATH_GET_FIELD = ".//input[contains(@id,'{{ val }}') and not (@type='submit')]";
   public static final String XPATH_GET_BUTTON = ".//input[contains(@id,'{{ val }}') and (@type='submit')]";
}
