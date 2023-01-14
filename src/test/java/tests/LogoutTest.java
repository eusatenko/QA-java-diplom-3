package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalAccountPage;
import testData.LoginTestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты выхода из аккаунта")
public class LogoutTest extends BaseTest{
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