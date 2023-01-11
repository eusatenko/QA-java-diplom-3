package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalAccountPage;
import testData.LoginTestData;

import static com.codeborne.selenide.Configuration.baseUrl;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты выхода из аккаунта")
public class LogoutTest {
    @Before
    public void setup() {
        // MAC - не открывался драйвер,  ругался на неизвестный источник, тогда:
        // Открыть терминал и перейти к пути, по которому загружается chromedriver. Ввести xattr -d com.apple.quarantine chromedriver
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
        baseUrl = "https://stellarburgers.nomoreparties.site";
    }

    @After
    public void end() {
        Selenide.closeWebDriver();
    }

    PersonalAccountPage personalAccountPage = new PersonalAccountPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    LoginTestData loginTestData = new LoginTestData();

    @DisplayName("Выход из аккаунта по кнопке [Выйти] из личного кабинета")
    @Test
    public void checkExitButtonFromPersonalAccount(){
        loginPage.openPage();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();
        assertThat("Переход не на страницу Входа",
                loginPage.getTextLoginButton(), equalTo("Войти"));
    }

}