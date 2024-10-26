package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static constants.Constants.*;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке Войти")
    public void clickSignInButton() {
        waitForElementToBeClickable(SIGN_IN_BUTTON_FORGOT_PASSWORD).click();
    }
}
