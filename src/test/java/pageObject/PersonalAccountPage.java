package pageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    // Кнопка "Профиль"
    SelenideElement profileButton = $(byXpath("//div/main/div/nav/ul/li[1]/a"));
    // Кнопка "Выход"
    SelenideElement exitButton = $(byXpath("//div/main/div/nav/ul/li[3]/button"));

    @Step("Получить текст кнопки [Профиль]")
    public String getTextProfileButton(){
        return profileButton.getText();
    }
    @Step("Получить текст кнопки [Выход]")
    public String getTextExitButton(){
        return exitButton.getText();
    }
    @Step("Проверка перехода в Личный кабинет")
    public void checkOpenPersonalAccount(){
        profileButton.shouldBe(Condition.visible).shouldHave(Condition.text("Профиль"));
        exitButton.shouldBe(Condition.visible).shouldHave(Condition.text("Выход"));
    }
    @Step("Нажать Выход")
    public void clickExitButton(){
        exitButton.shouldBe(Condition.visible).click();
    }
}
