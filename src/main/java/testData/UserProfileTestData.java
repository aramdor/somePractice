package testData;

import utils.ApplicationProperties;

public class UserProfileTestData {
    public static final String URL_USER_PROFILE_PAGE = ApplicationProperties.applicationUri + "/user";

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_CHANGE_PASSWORD_DIALOG = ".//*[contains (@id ,'ChangePasswordDialog.changePasswordDlg') and contains(@style, 'display: {{ val }}')]";
    public static final String XPATH_USER_PROFILE_CONTAINER = ".//*[contains (@id, 'userProfileContainer')]";
}
