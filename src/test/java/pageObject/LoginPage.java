package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    // Поле Email
    SelenideElement emailField = $(byXpath("//div/main/div/form/fieldset[1]/div/div/input"));
    // Поле Пароль
    SelenideElement passwordField = $(byXpath("//div/main/div/form/fieldset[2]/div/div/input"));
    // Кнопка "Войти"
    SelenideElement loginButton = $(byText("Войти"));

    @Step("Открыть страницу Логина")
    public void openPage() {
        open("/login");
    }

    @Step("Получить текст кнопки [Войти] на странице логина")
    public String getTextLoginButton(){
        loginButton.shouldBe(Condition.visible);
        return loginButton.getText();
    }

    @Step("Заполнение поля Email")
    public void typeEmail(String email) {
        emailField.shouldBe(Condition.visible).setValue(email);
    }
    @Step("Заполнение поля Пароль")
    public void typePassword(String password) {
        passwordField.shouldBe(Condition.visible).setValue(password);
    }
    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }

    @Step("Заполнение полей Почта, Пароль + Клик по кнопке [Войти]")
    public void typeRegisterDataAndClickLoginButton(String email, String password){
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
}
