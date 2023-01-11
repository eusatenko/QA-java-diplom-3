package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {
    @Step("Открыть страницу Регистрации")
    public void openPage() {
        open("/register");
    }
    // Локаторы
    // Поле ввода имени
    SelenideElement nameField = $(byXpath("//div/main/div/form/fieldset[1]/div/div/input"));
    // Поле ввода почты
    SelenideElement emailField = $(byXpath("//div/main/div/form/fieldset[2]/div/div/input"));
    // Поле ввода пароля
    SelenideElement passwordField = $(byXpath("//div/main/div/form/fieldset[3]/div/div/input"));
    // Кнопка "Зарегистрироваться"
    SelenideElement registerButton = $(byText("Зарегистрироваться"));
    // Текст при вводе пароля меньше 6 символов
    SelenideElement textWrongPassword = $(byXpath("//div/main/div/form/fieldset[3]/div/p"));
    // Кнопка "Войти"
    SelenideElement loginButton = $(byXpath("//div/main/div/div/p/a"));

    // Заполнение полей
    @Step("Заполнение поля Имя")
    public void typeName(String name) {
        nameField.shouldBe(Condition.visible).setValue(name);
    }
    @Step("Заполнение поля Email")
    public void typeEmail(String email) {
        emailField.shouldBe(Condition.visible).setValue(email);
    }
    @Step("Заполнение поля Пароль")
    public void typePassword(String password) {
        passwordField.shouldBe(Condition.visible).setValue(password);
    }
    @Step("Клик по кнопке регистрации")
    public void clickRegisterButton() {
        registerButton.shouldBe(Condition.visible).click();
    }
    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }
    @Step("Заполнение полей Имя, Почта, Пароль + Клик по кнопке регистрации")
    public void typeRegisterDataAndClickRegisterButton(String name, String email, String password){
        typeName(name);
        typeEmail(email);
        typePassword(password);
        clickRegisterButton();
    }
    // Проверки
    @Step("Текст при не верном заполнении поля Пароль")
    public String getTextWrongPassword(){
        return textWrongPassword.getText();
    }
}
