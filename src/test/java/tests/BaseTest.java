package tests;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Configuration.baseUrl;

//Для запуска тестов в выбранном браузере!
//        mvn clean test -Dbrowser=CHROME
//        mvn clean test -Dbrowser=YANDEX
//        mvn clean test -Dbrowser=FIREFOX

public class BaseTest {
    @Before
    public void setup() {
        // MAC - не открывался драйвер,  ругался на неизвестный источник, тогда:
        // Открыть терминал и перейти к пути, по которому загружается chromedriver. Ввести xattr -d com.apple.quarantine chromedriver
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
        baseUrl = "https://stellarburgers.nomoreparties.site";
    }

    @After
    public void end(){
        Selenide.closeWebDriver();
    }
}
