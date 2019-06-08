package testData;

import utils.ApplicationProperties;

public class UsersAdministrationTestData {
    public static final String URL_USERS_ADMINISTRATION_RELATIVE = "/users";
    public static final String URL_USERS_ADMINISTRATION_FULL = ApplicationProperties.applicationUri + URL_USERS_ADMINISTRATION_RELATIVE;

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_USER_PANEL_CONTAINER = "//*[contains (@id, 'userPanel')]";
    public static final String XPATH_EDIT_PANEL_CONTAINER = "//*[contains (@id, 'editUserPanel')]";
    public static final String XPATH_FIND_USER_CONTAINER = "//div[@class = 'jt-panel jt-fieldset']";
    public static final String XPATH_USER_LIST = ".//*[contains (@id, 'usersList')]";
    //////////////////////Create new user//////////////////////
    public static final String XPATH_CREATE_NEW_USER_BUTTON = "//*[contains (@id ,'createNewUser')]";
    public static final String XPATH_CREATE_NEW_USER_DIALOG = ".//*[contains (@id ,'createUserDialog')]";
    //////////////////////Users list//////////////////////
    public static final String XPATH_COLUMN_FROM_THE_ROW = ".//*[contains (@id ,'{{ val }}')]";
    public static final String XPATH_COLUMN_FROM_THE_ROW_BY_TITLE = ".//td/*[@title = '{{ val }}']";
    public static final String XPATH_LAST_ACCESS_COLUMN = ".//td[@class = 'align-center']";
    public static final String XPATH_ALL_USERS_GROUP_LINK = ".//td//a[@href = '/editGroup/All%20Users']";
    public static final String XPATH_NEW_USERS_GROUP_LINK = ".//td//a[@href = '/editGroup/New%20Users']";
    public static final String XPATH_NO_USERS_FOUND_NOTIFICATION = ".//p[@class = 'note']";
    public static final String XPATH_AMOUNT_OF_USERS = ".//*[@class = 'light']";
}
