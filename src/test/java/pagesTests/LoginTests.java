package pagesTests;

import io.qameta.allure.Description;
import models.User;
import models.UserResponse;
import network.UserManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import generator.ObjectGenerator;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTests extends BaseTest {

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
    @Description("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void testLoginFromMainPage() {
        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @Description("Проверка входа через кнопку «Личный кабинет»")
    public void testLoginFromPersonalAccountButton() {
        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @Description("Проверка входа через кнопку в форме регистрации")
    public void testLoginFromRegistrationForm() {
        RegistrationPage registerPage = new RegistrationPage(driver);
        mainPage.clickSignInButton();
        loginPage.clickRegisterButton();
        registerPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void testLoginFromPasswordRecoveryForm() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.clickSignInButton();
        loginPage.enterEmailAndPassword(user.getEmail(), user.getPassword());
        loginPage.clickSignInButton();
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
