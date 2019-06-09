import atlasInstances.elements.DropDown;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.LoginTestData;
import testData.UserObject;
import utils.ApplicationManager;

public class testExecutor {
    private ApplicationManager app;
    private UserObject baseUser = new UserObject("login", "password", "password", true, "Vasiliy Testov", "iaroslav.stepanov@t-systems.com", "123", "—");

    ///////////////////////////////Before and after actions///////////////////////////////

    @BeforeMethod(alwaysRun = true)
    public void driverInit(ITestContext iTestContext) {
        app = new ApplicationManager(iTestContext);
        app.getDriver();

        app.openUrlAndWait(LoginTestData.URL_LOGIN_PAGE);
        app.onLoginPage()
                .inputUsername(LoginTestData.LOGIN_NAME)
                .inputPassword(LoginTestData.PASSWORD)
                .submit();
        app.onDashboardPage()
                .isDashboardPageLoaded()
                .openAdminDropdown()
                .clickOnFieldInAdminDropdown(DropDown.administrationUsers);
    }

    @AfterMethod
    public void driverStop(ITestContext context) {
        app.stop();
    }

    ///////////////////////////////Test cases///////////////////////////////

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to create new user")
    public void createNewUser() {
        UserObject currentUser = baseUser;

        app.onUsersPage()
                .isUsersPageLoaded()
                .deleteUserWithExactlyTheSameLogin(currentUser.getLogin())
                .deleteAllUsersIfUserLimitIsExceeded()
                .openCreateNewUserDialog()
                .fillLoginField(currentUser.getLogin())
                .fillPasswordField(currentUser.getPassword())
                .fillConfirmPasswordField(currentUser.getPasswordConfirmation())
                .clickOnTheForcePasswordChangeCheckbox()
                .fillFullNameField(currentUser.getFullName())
                .fillEmailField(currentUser.getEmail())
                .fillJabberField(currentUser.getJabber())
                .clickOkButton();
        app.onEditUserPage()
                .wasEditUserPageLoaded();
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Debug method to search for the existing user and delete it if required")
    public void deleteUserWithTheSameName() {
        UserObject currentUser = baseUser;

        app.onUsersPage()
                .isUsersPageLoaded()
                .fillFindField(currentUser.getLogin())
                .startSearch()
                .deleteUserWithExactlyTheSameLogin(currentUser.getLogin())
        ;
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Check that we are not able to create new user with existing login name")
    public void createNewUserWithExistingLoginName() {
        UserObject currentUser = baseUser;
        currentUser.setLogin("login22");

        app.onUsersPage()
                .isUsersPageLoaded()
                .deleteAllUsersIfUserLimitIsExceeded()
                .createUserIfItDoesNotExists(app, currentUser)
                .openCreateNewUserDialog()
                .fillLoginField(currentUser.getLogin())
                .fillPasswordField(currentUser.getPassword())
                .fillConfirmPasswordField(currentUser.getPasswordConfirmation())
                .clickOnTheForcePasswordChangeCheckbox()
                .fillFullNameField(currentUser.getFullName())
                .fillEmailField(currentUser.getEmail())
                .fillJabberField(currentUser.getJabber())
                .clickOkButton()
                .checkPopupError();
    }

    @DataProvider(name = "validUsers")
    public Object[][] userFormData() {
        return new Object[][]{
                new Object[]{new UserObject()
                        .setLogin("login")
                        .setPassword("PaSsWorD")
                        .setPasswordConfirmation("PaSsWorD")}, //regular user with mandatory fields only
                new Object[]{new UserObject()
                        .setLogin("!\"#$%&'()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQR")
                        .setPassword("!\"#$%&'()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQR<>/")
                        .setPasswordConfirmation("!\"#$%&'()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQR<>/")
                        .setForcePasswordChangeCheckbox(true)
                        .setFullName("!#$%&()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
                        .setJabber("!#$%&()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
                        .setEmail("!#$%&()*+,-.0123456789:;=?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")}, //all basic Latin symbols part 1 for all fields
                new Object[]{new UserObject()
                        .setLogin("STUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
                        .setPassword("STUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
                        .setPasswordConfirmation("STUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")
                        .setForcePasswordChangeCheckbox(false)
                        .setFullName("VWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")}, //all basic Latin symbols part 2
                new Object[]{new UserObject()
                        .setLogin("豈更車賈滑串句龜龜契金喇奈懶癩羅蘿螺裸邏樂洛烙珞落酪駱亂卵欄爛蘭鸞嵐濫藍襤拉臘蠟廊朗")  //magic redirect!!
                        .setPassword("password")
                        .setPasswordConfirmation("password")}, //CJK Compatibility Ideographs
                new Object[]{new UserObject()
                        .setLogin("a")
                        .setPassword("a")
                        .setPasswordConfirmation("a")
                        .setEmail("Email")}, //1 symbol account
                new Object[]{new UserObject()
                        .setLogin("1")
                        .setPassword("1")
                        .setPasswordConfirmation("1")
                        .setJabber("Jabber")},
                new Object[]{new UserObject()
                        .setLogin("@")
                        .setPassword("@")
                        .setPasswordConfirmation("@")},
                new Object[]{new UserObject()
                        .setLogin("äöü")
                        .setPassword("äöü")
                        .setPasswordConfirmation("äöü")
                        .setFullName("äöü")
                        .setEmail("äöü")
                        .setJabber("äöü")},
                new Object[]{new UserObject()
                        .setLogin("a")
                        .setPassword("a")
                        .setPasswordConfirmation("a")
                        .setFullName("n a m e")
                        .setEmail("e m a i l")
                        .setJabber("j a b b e r")},
//                Comments:
//                </> //negative. Not allowed for the login field
//                '" could not be checked for the full name, jabber and email fields because it could not be used in xpath and I am not able to get this fields in other way
        };
    }

    @Owner("Iaroslav Stepanov")
    @Test(dataProvider = "validUsers")
    @Description("Positive test: Create users with all fields combinations")
    public void createNewUserPositive(UserObject currentUser) {
        app.onUsersPage()
                .isUsersPageLoaded()
                .deleteUserWithExactlyTheSameLogin(currentUser.getLogin())
                .deleteAllUsersIfUserLimitIsExceeded()
                .openCreateNewUserDialog()
                .fillCreateUserDialogFieldsAccordingToTestData(app, currentUser)
                .clickOkButton();
        app.onEditUserPage()
                .wasEditUserPageLoaded()
                .clickOnUsersLinkInLeftSidebar();
        app.onUsersPage()
                .isUsersPageLoaded()
                .checkExistingUserFieldsAccordingToTestData(currentUser);
    }

    @Owner("Iaroslav Stepanov")
    @Test
    @Description("Check that user was NOT created if users tap on Cancel button")
    public void cancelNewUserCreation() {
        UserObject currentUser = baseUser;
        app.onUsersPage()
                .isUsersPageLoaded()
                .deleteUserWithExactlyTheSameLogin(currentUser.getLogin())
                .deleteAllUsersIfUserLimitIsExceeded()
                .openCreateNewUserDialog()
                .fillCreateUserDialogFieldsAccordingToTestData(app, currentUser)
                .clickCancelButton()
                .isCreateNewUserDialogDisplayed(false)
                .doesUserAlreadyExistsWithAssert(currentUser.getLogin(), false)
                .openCreateNewUserDialog()
                .areCreateNewUserDialogFieldsEmpty();
    }
    //login under the new user
    //check force password change button
    //input more than field allows
    //copy paste in fields

}
