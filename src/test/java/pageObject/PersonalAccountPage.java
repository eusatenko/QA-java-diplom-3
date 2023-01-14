package pageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    // Кнопка "Профиль"
    SelenideElement profileButton = $(byXpath(".//a[text()='Профиль']"));
    // Кнопка "История заказов"
    SelenideElement orderStoryButton = $(byCssSelector("a[href='/account/order-history']"));
    // Кнопка "Выход"
    SelenideElement exitButton = $(byXpath(".//button[text()='Выход']"));

    @Step("Получить текст кнопки [Профиль]")
    public String getTextProfileButton(){
        return profileButton.getText();
    }
    @Step("Получить текст кнопки [История заказов]")
    public String getTextOrderStoryButton(){
        return orderStoryButton.getText();
    }@Step("Получить текст кнопки [Выход]")
    public String getTextExitButton(){
        return exitButton.getText();
    }
    @Step("Проверка перехода в Личный кабинет")
    public void checkOpenPersonalAccount(){
        profileButton.shouldBe(Condition.visible).shouldHave(Condition.text("Профиль"));
        orderStoryButton.shouldBe(Condition.visible).shouldHave(Condition.text("История заказов"));
        exitButton.shouldBe(Condition.visible).shouldHave(Condition.text("Выход"));
    }
    @Step("Нажать Выход")
    public void clickExitButton(){
        exitButton.shouldBe(Condition.visible).click();
    }
}
