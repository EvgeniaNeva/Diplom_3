package pagesTests;

import generator.ObjectGenerator;
import io.qameta.allure.Description;
import models.User;
import models.UserResponse;
import network.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;

public class ProfileNavigationTest extends BaseTest {
    private MainPage mainPage;
    private ProfilePage profilePage;
    private UserManager userManager;
    private String accessToken;

    @Before
    public void setUp() {
        userManager = new UserManager();
        User user = ObjectGenerator.generateUser();
        accessToken = userManager.createUser(user)
                .body("success", equalTo(true))
                .statusCode(200)
                .extract()
                .body()
                .as(UserResponse.class)
                .getAccessToken();
        WebDriver driver = getDriver();
        mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
    }

    @Test
    @Description("Проверка перехода по клику на логотип Stellar Burgers")
    public void testLogoNavigation() {
        profilePage.clickLogoButton();
        mainPage.checkOrderButton();
    }

    @Test
    @Description("Проверка перехода по клику на «Конструктор»")
    public void testConstructorNavigation() {
        profilePage.clickConstructorButton();
        mainPage.checkOrderButton();
    }

    @After
    public void tearDown() {
        super.tearDown();

        if (accessToken != null && !accessToken.isEmpty()) {
            userManager.deleteUser(accessToken);
        }
    }
}
