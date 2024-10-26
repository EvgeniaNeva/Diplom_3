package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static constants.Constants.*;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        open("");
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickAccountButton() {
        waitForElementToBeClickable(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Клик по кнопке Войти")
    public void clickSignInButton() {
        waitForElementToBeClickable(SIGN_IN_ACCOUNT_BUTTON).click();
    }

    @Step("Проверка наличия кнопки заказа")
    public void checkOrderButton() {
        String textOrderButton = waitForElementToBeVisible(MAKE_ORDER_BUTTON).getText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }

    @Step("Клик на кнопку Булки")
    public void clickBunsButton() {
        waitForElementToBeClickable(BUNS_BUTTON).click();
    }

    @Step("Клик на кнопку Соусы")
    public void clickSaucesButton() {
        waitForElementToBeClickable(SAUCES_BUTTON).click();
    }

    @Step("Клик на кнопку Начинки")
    public void clickFillingsButton() {
        waitForElementToBeClickable(FILLINGS_BUTTON).click();
    }

    @Step("Проверка отображения кнопки Войти на экране")
    public void checkGoToTheBunsSection() {
        String text = waitForElementToBeClickable(By.xpath(".//div[@style]/div[1]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_type_current"));
    }

    @Step("Проверка отображения кнопки Войти на экране")
    public void checkGoToTheSaucesSection() {
        String text = waitForElementToBeClickable(By.xpath(".//div[@style]/div[2]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_type_current"));
    }

    @Step("Проверка отображения кнопки Войти на экране")
    public void checkGoToTheFillingsSection() {
        String text = waitForElementToBeClickable(By.xpath(".//div[@style]/div[3]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_type_current"));
    }
}
