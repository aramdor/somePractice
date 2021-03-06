package testData;

import utils.ApplicationProperties;

public class DashboardTestData {
    public static final String URL_DASHBOARD = ApplicationProperties.applicationUri + "/dashboard";

    /////////////////////////XPATHS/////////////////////////
    public static final String XPATH_ADMINISTRATION = ".//*[@title = 'Administration']";
    public static final String XPATH_USER_NAME = ".//*[contains(@data-ring-dropdown, '\"label\":\"Log out\"')]";
}
