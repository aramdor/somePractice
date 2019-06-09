package testData;

public class CommonTestData {
    public static final String LOGOUT_HREF = "#";

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_DEFAULT_TOP_TOOLBAR = "//*[@class = 'ring-menu']";
    public static final String XPATH_DEFAULT_DROPDOWN = "//*[@class = 'ring-dropdown']";
    public static final String XPATH_DROPDOWN_BY_HREF = ".//*[@href ='{{ val }}']";

    ////////////////////Default form xpaths////////////////////
    public static final String XPATH_DEFAULT_FIELD = ".//input[contains(@id,'{{ val }}') and not (@type='submit')]";
    public static final String XPATH_DEFAULT_CHECKBOX = ".//input[contains(@id,'{{ val }}') and (@type='checkbox')]";
    public static final String XPATH_DEFAULT_FIELD_LABEL = ".//label[contains(@id,'{{ val }}')]";
    public static final String XPATH_DEFAULT_BUTTON = ".//button[contains(@id,'{{ val }}')]";

    ////////////////////Default form xpaths - tables and popups////////////////////
    public static final String XPATH_TABLE_ROWS = ".//tbody//tr";
    public static final String XPATH_POPUP = "//*[contains(@id,'popup')]";
    public static final String XPATH_MESSAGE_POPUP = "//*[contains(@id,'popup') and (@class='message ')]";
    public static final String XPATH_ERROR_DESCRIPTION = ".//td[not(@class)]";

    ////////////////////Is element shown////////////////////
    public static final String dialogIsShown = "block";
    public static final String dialogIsNotShown = "none";

    ////////////////////Bulb errors////////////////////
    public static final String XPATH_DEFAULT_FIELD_WITH_BULB_ERROR = ".//input[contains(@id,'{{ val }}') and not (@type='submit') and (@class='jt-input form-has-error')]";
    public static final String XPATH_ALL_BULB_ERRORS = "//*[@class='error-bulb2']";
    public static final String XPATH_BULB_ERROR_TOOLTIP = "//*[@class='error-tooltip tooltip']";



}
