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

public class AccountTest extends BaseTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private User user;
    private UserManager userManager;
    private String accessToken;

    @Before
    public void setUp() {
        userManager = new UserManager();
        user = ObjectGenerator.generateUser();
        accessToken = userManager.createUser(user)
                .body("success", equalTo(true))
                .statusCode(200)
                .extract()
                .body()
                .as(UserResponse.class)
                .getAccessToken();
        driver = getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @Description("Проверка переход по клику на «Личный кабинет»")
    public void testAccount() {
        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        sleep();
        mainPage.clickAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkLogoutButton();
    }

    @Test
    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        loginPage.checkSignInButton();
    }

    @After
    public void tearDown() {
        super.tearDown();
        if (accessToken != null && !accessToken.isEmpty()) {
            userManager.deleteUser(accessToken);
        }
    }
}
