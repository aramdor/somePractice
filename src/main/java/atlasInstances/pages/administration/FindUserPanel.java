package atlasInstances.pages.administration;

import atlasInstances.elements.DefaultForm;
import io.qameta.atlas.webdriver.WebPage;

public interface FindUserPanel extends WebPage, DefaultForm {
    String find = "queryText";
    String searchButton = "searchButton";
    String resetButton = "resetButton";
}
