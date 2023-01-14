package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Тесты нажатия разделов конструктора Бургеров")
public class ConstructorSectionTest extends BaseTest{
    MainPage mainPage = new MainPage();

    @DisplayName("Клик на [Булки]")
    @Test
    public void checkClickBunInConstructor() {
        open(baseUrl);
        mainPage.clickToppingButton();
        mainPage.clickBunButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("tab_type_current"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("noselect"));
    }
    @DisplayName("Клик на [Соусы]")
    @Test
    public void checkClickSauceInConstructor() {
        open(baseUrl);
        mainPage.clickSauceButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("tab_type_current"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("noselect"));
    }
    @DisplayName("Клик на [Начинки]")
    @Test
    public void checkClickToppingInConstructor() {
        open(baseUrl);
        mainPage.clickToppingButton();
        assertThat(mainPage.getTextDomAtrBun(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrSauce(), containsString("noselect"));
        assertThat(mainPage.getTextDomAtrTopping(), containsString("tab_type_current"));
    }
}
