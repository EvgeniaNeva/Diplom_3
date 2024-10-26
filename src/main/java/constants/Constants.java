package constants;

import org.openqa.selenium.By;

public class Constants {
    public static final String BASE_URL ="https://stellarburgers.nomoreparties.site/";
    public static final String USER_LOGIN_URL = "api/auth/login";
    public static final String USER_REGISTER_URL = "api/auth/register";
    public static final String USER_URL = "api/auth/user";

    public static final By SIGN_IN_BUTTON_FORGOT_PASSWORD =
            By.xpath(".//a[text()='Войти']");

    public static final By REGISTER_BUTTON =
            By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");

    public static final By RESTORE_PASSWORD_BUTTON =
            By.xpath(".//a[text()='Восстановить пароль']");

    public static final By SIGN_IN_BUTTON_LOGIN =
            By.xpath(".//button[text()='Войти']");

    public static final By EMAIL_FIELD =
            By.xpath(".//label[text()='Email']/following-sibling::input");

    public static final By PASSWORD_FIELD =
            By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public static final By PERSONAL_ACCOUNT_BUTTON =
            By.xpath(".//p[contains(text(), 'Личный')]");

    public static final By SIGN_IN_ACCOUNT_BUTTON =
            By.xpath(".//button[contains(text(),'Войти в аккаунт')]");

    public static final By MAKE_ORDER_BUTTON =
            By.xpath(".//button[contains(text(),'Оформить заказ')]");

    public static final By BUNS_BUTTON =
            By.xpath(".//div[span[text()='Булки']]");

    public static final By SAUCES_BUTTON =
            By.xpath(".//div[span[text()='Соусы']]");

    public static final By FILLINGS_BUTTON =
            By.xpath(".//*[text()='Начинки']");

    public static final By LOGOUT_BUTTON =
            By.xpath(".//button[text() = 'Выход']");

    public static final By CONSTRUCTOR_BUTTON =
            By.xpath(".//p[text()='Конструктор']");

    public static final By LOGO_BUTTON =
            By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public static final By NAME_FIELD =
            By.xpath(".//label[text()='Имя']/following-sibling::input");

    public static final By REGISTER_EMAIL_FIELD =
            By.xpath(".//label[text()='Email']/following-sibling::input");

    public static final By REGISTER_PASSWORD_FIELD =
            By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public static final By REGISTER_BUTTON_ALT =
            By.xpath(".//button[text()='Зарегистрироваться']");

    public static final By SHORT_PASSWORD_ERROR =
            By.xpath(".//p[text()='Некорректный пароль']");

    public static final By SIGN_IN_BUTTON_REGISTRATION =
            By.xpath(".//a[text()='Войти']");
}
