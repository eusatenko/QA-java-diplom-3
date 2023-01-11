package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // Кнопка "Войти" или "Оформить заказ" в зависимости от того авторизован пользователь или нет
    SelenideElement loginOrCreateOrderButton = $(byXpath("//div/main/section[2]/div/button"));
    // Кнопка "Личный кабинет"
    SelenideElement personalAccountButton = $(byText("Личный Кабинет"));
    // Кнопка "Конструктор"
    SelenideElement constructorButton = $(byXpath("//div/header/nav/ul/li[1]/a/p"));
    // Кнопка "Логотип"
    SelenideElement logoButton = $(byXpath("//div/header/nav/div/a"));
    // Надпись "Соберите бургер"
    SelenideElement textCreateBurger = $(byXpath("//div/main/section[1]/h1"));
    /* КОНСТРУКТОР БУРГЕРА */
    // Булки
    SelenideElement constructorBunButton = $(byXpath("//div/main/section[1]/div[1]/div[1]"));
    // Соусы
    SelenideElement constructorSauceButton = $(byXpath("//div/main/section[1]/div[1]/div[2]"));
    // Начинки
    SelenideElement constructorToppingButton = $(byXpath("//div/main/section[1]/div[1]/div[3]"));

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
