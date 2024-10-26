package pagesTests;

import browsers.Browser;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;
    Browser browser = Browser.CHROME;

    public WebDriver getDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Users/evgenia/Downloads/Diplom_3/src/test/java/browsers/chromedriver");
                driver = new ChromeDriver(options);
                return driver;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "/Users/evgenia/Downloads/Diplom_3/src/test/java/browsers/yandexdriver");
                driver = new ChromeDriver(options);
                return driver;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void sleep() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса прерывания
        }
    }
}
