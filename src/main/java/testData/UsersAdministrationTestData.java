package testData;

import utils.ApplicationProperties;

public class UsersAdministrationTestData {
    public static final String URL_USERS_ADMINISTRATION_RELATIVE = "/users";
    public static final String URL_USERS_ADMINISTRATION_FULL = ApplicationProperties.applicationUri + URL_USERS_ADMINISTRATION_RELATIVE;

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_USER_PANEL_CONTAINER = "//*[contains (@id, 'userPanel')]";
    public static final String XPATH_FIND_USER_CONTAINER = "//div[@class = 'jt-panel jt-fieldset']";
    public static final String XPATH_USER_LIST = ".//*[contains (@id, 'usersList')]";
    //////////////////////Create new user//////////////////////
    public static final String XPATH_CREATE_NEW_USER_BUTTON = "//*[contains (@id ,'createNewUser')]";
    public static final String XPATH_CREATE_NEW_USER_DIALOG = ".//*[contains (@id ,'createUserDialog')]";
    //////////////////////Users list//////////////////////
    public static final String XPATH_COLUMN_FROM_THE_ROW = ".//*[contains (@id ,'{{ val }}')]";
    public static final String XPATH_TABLE_ROWS = ".//tbody//tr";
    public static final String XPATH_NO_USERS_FOUND_NOTIFICATION = ".//p[@class = 'note']";
}
