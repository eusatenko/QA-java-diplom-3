package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordPage {
    // Кнопка "Войти"
    SelenideElement loginButton = $(byXpath(".//a[text()='Войти']"));
    @Step("Открыть страницу восстановления пароля")
    public void openPage(){open("/forgot-password");}

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
    }
}
