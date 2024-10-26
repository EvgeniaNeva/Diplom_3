package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static constants.Constants.*;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка наличия кнопки Выйти")
    public void checkLogoutButton() {
        String textOfLogoutButton = waitForElementToBeVisible(LOGOUT_BUTTON).getText();
        MatcherAssert.assertThat(textOfLogoutButton, startsWith("Выход"));
    }

    @Step("Клик по кнопке Выход")
    public void clickLogoutButton() {
        waitForElementToBeClickable(LOGOUT_BUTTON).click();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        waitForElementToBeClickable(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Клик по логотипу")
    public void clickLogoButton() {
        waitForElementToBeClickable(LOGO_BUTTON).click();
    }
}
