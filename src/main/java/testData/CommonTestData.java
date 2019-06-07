package testData;

public class CommonTestData {
    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_DEFAULT_TOP_TOOLBAR = "//*[@class = 'ring-menu']";
    public static final String XPATH_DEFAULT_DROPDOWN = "//*[@class = 'ring-dropdown']";

    ////////////////////Default form xpaths////////////////////
    public static final String XPATH_DEFAULT_FIELD = ".//input[contains(@id,'{{ val }}') and not (@type='submit')]";
    public static final String XPATH_DEFAULT_CHECKBOX = ".//input[contains(@id,'{{ val }}') and (@type='checkbox')]";
    public static final String XPATH_DEFAULT_FIELD_LABEL = ".//label[contains(@id,'{{ val }}')]";
    public static final String XPATH_DEFAULT_BUTTON = ".//button[contains(@id,'{{ val }}')]";

    ////////////////////Default form xpaths - tables and popups////////////////////
    public static final String XPATH_TABLE_ROWS = ".//tbody//tr";
    public static final String XPATH_POPUP = "//*[contains(@id,'popup')]";
    public static final String XPATH_ERROR_DESCRIPTION = ".//td[not(@class)]";



}
