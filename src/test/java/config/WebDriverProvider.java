package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

    private WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }


    public WebDriver createDriver() {
        WebDriver driver = getDriver();
        driver.get(config.getBaseURL());
        return driver;
    }

    private WebDriver getDriver() {
        //для указания в каком браузере запускать тест
        final Browser browser = config.getBrowser();
        switch (browser) {
            case YANDEX: {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
                return new ChromeDriver();
            }
            case CHROME: {
                return new ChromeDriver();
            }
            case FIREFOX: {
                return new FirefoxDriver();
            }
        }
        throw new RuntimeException("No such browder: " + browser);
    }
}
