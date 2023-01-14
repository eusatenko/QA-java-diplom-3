package tests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalAccountPage;
import testData.LoginTestData;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты перехода в [Личный кабинет] и из него")
public class PersonalAccountTest extends BaseTest {
    PersonalAccountPage personalAccountPage = new PersonalAccountPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    LoginTestData loginTestData = new LoginTestData();

    @Step("Вход пользователем и проверка открытия страницы [Личный кабинет]")
    public void loginAndCheckAuth() {
        loginPage.openPage();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.checkOpenPersonalAccount();
    }

    @DisplayName("Переход с главной в [Личный кабинет] с авторизацией")
    @Test
    public void checkClickPersonalAccountOnMainPageWithAuth(){
        loginAndCheckAuth();
        assertThat("Нет кнопки Профиль",
                personalAccountPage.getTextProfileButton(),
                equalTo("Профиль"));assertThat("Нет кнопки Профиль",
                personalAccountPage.getTextOrderStoryButton(),
                equalTo("История заказов"));
        assertThat("Нет кнопки Выход",
                personalAccountPage.getTextExitButton(),
                equalTo("Выход"));
    }

    @DisplayName("Переход с главной в [Личный кабинет] без авторизации")
    @Test
    public void checkClickPersonalAccountOnMainPageWithoutAuth(){
        open(baseUrl);
        mainPage.clickPersonalAccountButton();
        assertThat("Переход не на страницу Входа",
                loginPage.getTextLoginButton(),
                equalTo("Войти"));
    }

    @DisplayName("Переход по клику [Конструктор] из личного кабинета")
    @Test
    public void checkSwitchFromPersonalAccountToConstructor(){
        loginAndCheckAuth();
        mainPage.clickConstructorButton();
        assertThat("Переход не на главную страницу",
                mainPage.getTextMainPageHaveCreateBurger(),
                equalTo("Соберите бургер"));
    }

    @DisplayName("Переход по клику на [Логотип] из личного кабинета")
    @Test
    public void checkSwitchFromPersonalAccountToLogo(){
        loginAndCheckAuth();
        mainPage.clickLogoButton();
        assertThat("Переход не на главную страницу",
                mainPage.getTextMainPageHaveCreateBurger(),
                equalTo("Соберите бургер"));
    }
}
