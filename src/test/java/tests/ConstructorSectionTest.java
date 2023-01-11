package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты нажатия разделов конструктора Бургеров")
public class ConstructorSectionTest {
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

    MainPage mainPage = new MainPage();

    @DisplayName("Клик на [Булки]")
    @Test
    public void checkClickBunInConstructor() {
        open(baseUrl);
        mainPage.clickToppingButton();
        mainPage.clickBunButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("tab_type_current"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("noselect"));
    }
    @DisplayName("Клик на [Соусы]")
    @Test
    public void checkClickSauceInConstructor() {
        open(baseUrl);
        mainPage.clickSauceButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("tab_type_current"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("noselect"));
    }
    @DisplayName("Клик на [Начинки]")
    @Test
    public void checkClickToppingInConstructor() {
        open(baseUrl);
        mainPage.clickToppingButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("tab_type_current"));
    }
}
