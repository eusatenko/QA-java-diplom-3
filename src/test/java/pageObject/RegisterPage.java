package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage {
    @Step("Открыть страницу Регистрации")
    public void openPage() {
        open("/register");
    }
    // Локаторы
    // Поле ввода имени. Нашли лейбл "Имя" и потом нашли ниже сестринский элемент с тегом input (если надо предшествующий - то preceding-sibling)
    SelenideElement nameField = $(byXpath(".//label[text()='Имя']/following-sibling::input"));
    // Поле ввода почты. Нашли лейбл "Email", поднялись к родителю и у него ищем ребенка с тегом input.
    SelenideElement emailField = $(byXpath(".//label[text()='Email']/../input"));
    // Поле ввода пароля
    SelenideElement passwordField = $(byXpath(".//label[text()='Пароль']/../input"));
    // Кнопка "Зарегистрироваться"
    SelenideElement registerButton = $(byXpath(".//button[text()='Зарегистрироваться']"));
    // Текст при вводе пароля меньше 6 символов
    SelenideElement textWrongPassword = $(byXpath(".//p[text()='Некорректный пароль']"));
    // Кнопка "Войти". Для себя 2 варианта, через xPath и CSS
//    SelenideElement loginButton = $(byXpath(".//a[text()='Войти']"));
    SelenideElement loginButton = $(byCssSelector("a[href='/login']"));

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
