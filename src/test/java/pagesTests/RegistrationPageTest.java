package pagesTests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest {

    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriver driver = getDriver();
        new MainPage(driver).clickAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Description("Проверка успешной регистрации")
    public void testSuccessfulRegistration() {
        registrationPage.inputName(RandomStringUtils.random(10, true, false));
        registrationPage.inputEmail(RandomStringUtils.random(10, true, false) + "@gmail.com");
        registrationPage.inputPassword(RandomStringUtils.random(10, false, true)); // Пароль менее 6 символов
        registrationPage.clickFinallyRegisterButton();
        loginPage.checkSignInButton();
    }

    @Test
    @Description("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    public void testShortPasswordError() {
        registrationPage.inputName(RandomStringUtils.random(10, true, false));
        registrationPage.inputEmail(RandomStringUtils.random(10, true, false) + "@gmail.com");
        registrationPage.inputPassword(RandomStringUtils.random(3, false, true)); // Пароль менее 6 символов
        registrationPage.clickFinallyRegisterButton();
        registrationPage.checkShortPasswordError();
    }
}
