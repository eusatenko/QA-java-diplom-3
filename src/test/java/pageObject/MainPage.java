package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // Кнопка "Войти" или "Оформить заказ" в зависимости от того авторизован пользователь или нет
    SelenideElement loginOrCreateOrderButton = $(byXpath(".//button[text()='Оформить заказ' or text()='Войти в аккаунт']"));
    // Кнопка "Личный кабинет"
    SelenideElement personalAccountButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    // Кнопка "Конструктор"
    SelenideElement constructorButton = $(byXpath(".//p[text()='Конструктор']"));
    // Кнопка "Логотип"
    SelenideElement logoButton = $(byCssSelector("div.AppHeader_header__logo__2D0X2"));
    // Надпись "Соберите бургер"
    SelenideElement textCreateBurger = $(byXpath(".//h1[text()='Соберите бургер']"));
    /* КОНСТРУКТОР БУРГЕРА */
    // Булки
    SelenideElement constructorBunButton = $(byXpath(".//span[text()='Булки']//parent::div"));
    // Соусы
    SelenideElement constructorSauceButton = $(byXpath(".//span[text()='Соусы']//parent::div"));
    // Начинки
    SelenideElement constructorToppingButton = $(byXpath(".//span[text()='Начинки']//parent::div"));

    @Step("Получить текст кнопки [Оформить заказ] или [Войти в аккаунт]")
    public String getTextLoginOrCreateOrderButton(){
        return loginOrCreateOrderButton.getText();
    }
    @Step("Нажать кнопку [Вход]")
    public void clickLoginOrCreateOrderButton() {
        loginOrCreateOrderButton.shouldBe(Condition.visible).click();
    }
    @Step("Нажать кнопку [Личный Кабинет]")
    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(Condition.visible).click();
    }
    @Step("Нажать кнопку [Конструктор]")
    public void clickConstructorButton() {
        constructorButton.shouldBe(Condition.visible).click();
    }
    @Step("Нажать кнопку [Логотип]")
    public void clickLogoButton() {
        logoButton.shouldBe(Condition.visible).click();
    }
    @Step("Нажать кнопку [Булки]")
    public void clickBunButton() {
        constructorBunButton.shouldBe(Condition.visible).click();
    }
    @Step("Текст атрибута кнопки [Булки]")
    public String getTextDomAtrBun(){
        return constructorBunButton.getDomAttribute("class");
    }
    @Step("Нажать кнопку [Соусы]")
    public void clickSauceButton() {
        constructorSauceButton.shouldBe(Condition.visible).click();
    }
    @Step("Текст атрибута кнопки [Соусы]")
    public String getTextDomAtrSauce(){
        return constructorSauceButton.getDomAttribute("class");
    }
    @Step("Нажать кнопку [Начинки]")
    public void clickToppingButton() {
        constructorToppingButton.shouldBe(Condition.visible).click();
    }
    @Step("Текст атрибута кнопки [Начинки]")
    public String getTextDomAtrTopping(){
        return constructorToppingButton.getDomAttribute("class");
    }
    @Step("Текст заголовка [Соберите бургер]")
    public String getTextMainPageHaveCreateBurger(){
        return textCreateBurger.getText();
    }
}
