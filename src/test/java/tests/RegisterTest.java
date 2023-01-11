package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.RegisterPage;
import com.github.javafaker.Faker;
import testData.RegisterTestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты регистрации Пользователя")
public class RegisterTest {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @Before
    public void setup() {
        // MAC - не открывался драйвер,  ругался на неизвестный источник, тогда:
        // Открыть терминал и перейти к пути, по которому загружается chromedriver. Ввести xattr -d com.apple.quarantine chromedriver
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
//        Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site";
    }
    @After
    public void end(){
        Selenide.closeWebDriver();
    }

    @DisplayName("Регистрация Пользователя с корректным паролем")
    @Test
    public void authWithCorrectPasswordTest() {
        RegisterTestData registerTestData = new RegisterTestData();

        registerPage.openPage();
        registerPage.typeRegisterDataAndClickRegisterButton(registerTestData.name,
                registerTestData.email,
                registerTestData.password);
        assertThat("Переход не на страницу Входа",
                loginPage.getTextLoginButton(), equalTo("Войти"));
    }

    @DisplayName("Регистрация Пользователя с некорректным паролем")
    @Test
    public void authWithWrongPasswordTest() {
        RegisterTestData registerTestData = new RegisterTestData();
        registerTestData.password = faker.internet().password(1,5);

        registerPage.openPage();
        registerPage.typeRegisterDataAndClickRegisterButton(registerTestData.name, registerTestData.email, registerTestData.password);
        assertThat("Нет текста Некорректный пароль",
                registerPage.getTextWrongPassword(), equalTo("Некорректный пароль"));
    }
}
