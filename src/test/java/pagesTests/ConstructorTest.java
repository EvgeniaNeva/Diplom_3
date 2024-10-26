package pagesTests;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class ConstructorTest extends BaseTest {
    private MainPage mainPage;

    @Before
    public void setUp() {
        WebDriver driver = getDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @Description("Проверка, что работают переходы к разделам")
    public void testConstructorMenu() {
        mainPage.clickSaucesButton();
        sleep();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickFillingsButton();
        sleep();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickBunsButton();
        sleep();
        mainPage.checkGoToTheBunsSection();
    }
}
