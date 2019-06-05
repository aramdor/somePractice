package testData;

import utils.ApplicationProperties;

public class UsersAdministrationTestData {
    public static final String URL_USERS_ADMINISTRATION_RELATIVE = "/users";
    public static final String URL_USERS_ADMINISTRATION_FULL = ApplicationProperties.applicationUri + URL_USERS_ADMINISTRATION_RELATIVE;

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_USER_PANEL_CONTAINER = "//*[contains (@id, 'userPanel')]";

        //////////////////////Create new user//////////////////////
        public static final String XPATH_CREATE_NEW_USER_BUTTON = ".//*[contains (@id ,'createNewUser')]";
        public static final String XPATH_CREATE_NEW_USER_DIALOG = ".//*[contains (@id ,'createUserDialog')]";

}
