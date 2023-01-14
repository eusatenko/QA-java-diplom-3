package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegisterPage;
import testData.LoginTestData;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты авторизации Пользователя [Вход] ")
public class LoginTest extends BaseTest{
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    LoginTestData loginTestData = new LoginTestData();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void checkLoginFromRegisterPage(){
        registerPage.openPage();
        registerPage.clickLoginButton();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        assertThat("Пользователь не авторизован или не верный текст кнопки",
                mainPage.getTextLoginOrCreateOrderButton(), equalTo("Оформить заказ"));
    }

    @DisplayName("Вход через кнопку [Войти] в аккаунт на главной")
    @Test
    public void checkLoginFromMainPage(){
        open(baseUrl);
        mainPage.clickLoginOrCreateOrderButton();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        assertThat("Пользователь не авторизован или не верный текст кнопки",
                mainPage.getTextLoginOrCreateOrderButton(), equalTo("Оформить заказ"));    }

    @DisplayName("Вход через кнопку [Личный кабинет] на главной")
    @Test
    public void checkLoginFromPersonalAccountPage(){
        open(baseUrl);
        mainPage.clickPersonalAccountButton();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        assertThat("Пользователь не авторизован или не верный текст кнопки",
                mainPage.getTextLoginOrCreateOrderButton(), equalTo("Оформить заказ"));    }

    @DisplayName("Вход через кнопку [Войти] в форме восстановления пароля")
    @Test
    public void checkLoginFromForgotPasswordPage(){
        forgotPasswordPage.openPage();
        forgotPasswordPage.clickLoginButton();
        loginPage.typeRegisterDataAndClickLoginButton(loginTestData.email, loginTestData.password);
        assertThat("Пользователь не авторизован или не верный текст кнопки",
                mainPage.getTextLoginOrCreateOrderButton(), equalTo("Оформить заказ"));    }
}
