package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static constants.Constants.*;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод имени в поле имени")
    public void inputName(String text) {
        waitForElementToBeVisible(NAME_FIELD).sendKeys(text);
    }

    @Step("Ввод email в поле email")
    public void inputEmail(String text) {
        waitForElementToBeVisible(REGISTER_EMAIL_FIELD).sendKeys(text);
    }

    @Step("Ввод пароля в поле пароля")
    public void inputPassword(String text) {
        waitForElementToBeVisible(REGISTER_PASSWORD_FIELD).sendKeys(text);
    }

    @Step("Клик на кнопку Регистрация")
    public void clickFinallyRegisterButton() {
        waitForElementToBeClickable(REGISTER_BUTTON_ALT).click();
    }

    @Step("Проверка наличия сообщения об ошибке")
    public void checkShortPasswordError() {
        String textOfError = waitForElementToBeVisible(SHORT_PASSWORD_ERROR).getText();
        MatcherAssert.assertThat("Ошибка пароля", textOfError, startsWith("Некорректный пароль"));
    }

    @Step("Клик на кнопку Войти")
    public void clickSignInButton() {
        waitForElementToBeClickable(SIGN_IN_BUTTON_REGISTRATION).click();
    }
}
