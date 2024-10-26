package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import static constants.Constants.*;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(String url) {
        super.open(url);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        waitForElementToBeVisible(REGISTER_BUTTON).click();
    }

    @Step("Ввод почты и пароля в окне авторизации")
    public void enterEmailAndPassword(String email, String password) {
        waitForElementToBeVisible(EMAIL_FIELD).sendKeys(email);
        waitForElementToBeVisible(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickSignInButton() {
        waitForElementToBeClickable(SIGN_IN_BUTTON_LOGIN).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickRestorePasswordButton() {
        waitForElementToBeClickable(RESTORE_PASSWORD_BUTTON).click();
    }

    @Step("Проверка отображения кнопки Войти на экране")
    public void checkSignInButton() {
        String textOfRestorePasswordButton = waitForElementToBeVisible(SIGN_IN_BUTTON_LOGIN).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Войти"));
    }
}
