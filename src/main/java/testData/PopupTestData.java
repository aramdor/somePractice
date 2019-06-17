package testData;

public class PopupTestData {
    public  static final String restrictedSpaceCharacterError = "Restricted character ' ' in the name";
    public  static final String loginShouldNotContain = "login shouldn't contain characters \"<\", \"/\", \">\": login";
    public static final String login = "login";

    public static String notUniqValueError(String userName) {
        return "Value should be unique: " + userName;
    }
}
