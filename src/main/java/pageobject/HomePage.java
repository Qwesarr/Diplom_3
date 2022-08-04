package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //Кнопка "войти"
    @FindBy(xpath = ".//button[contains(@class,'button_button')][contains(text(),'Войти в аккаунт')]")
    private SelenideElement loginButton;
    public void clickLoginButton() {
        loginButton.scrollTo().click();
    }

    //Кнопка оформить заказ
    @FindBy(xpath = ".//button[contains(@class,'button_button')][contains(text(),'Оформить заказ')]")
    private SelenideElement createOrderButton;
    public boolean waitCreateOrderButton(){
        createOrderButton.shouldBe(visible);
        return createOrderButton.exists();
    }

    //Ссылка на личный кабинет
    @FindBy(xpath = ".//p[contains(@class,'AppHeader_header')][contains(text(),'Личный Кабинет')]/..")
    private SelenideElement personalAccountLink;
    public void clickPersonalAccountLink() {
        personalAccountLink.scrollTo().click();
    }

    //Прокрутка до булок
    @FindBy(xpath = ".//span[contains(@class,'text')][contains(text(),'Булки')]/..")
    private SelenideElement bunsScrollButton;
    public void clickBunsScrollButton() {
        bunsScrollButton.click();
    }

    //кнопка прокрутки до булок, когда выполнена прокрутка до соуса (по нажатию, или через ручную прокрутку). Файндер получается каким то сложным
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current')]/span[contains(@class,'text')][contains(text(),'Булки')]")
    private SelenideElement bunScrollCurrentButton;
    public boolean waitBunScrollCurrentButton(){
        bunScrollCurrentButton.shouldBe(visible);
        return bunScrollCurrentButton.exists();
    }

    //Прокрутка до соуса
    @FindBy(xpath = ".//span[contains(@class,'text')][contains(text(),'Соусы')]/..")
    private SelenideElement sauceScrollButton;

    public void clickSauceScroll() {
        sauceScrollButton.click();
    }

    //кнопка прокрутки до соуса, когда выполнена прокрутка до соуса (по нажатию, или через ручную прокрутку). Файндер получается каким то сложным
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current')]/span[contains(@class,'text')][contains(text(),'Соусы')]")
    private SelenideElement sauceScrollCurrentButton;
    public boolean waitSauceScrollCurrentButton(){
        sauceScrollCurrentButton.shouldBe(visible);
        return sauceScrollCurrentButton.exists();
    }

    //Прокрутка до начинки
    @FindBy(xpath = ".//span[contains(@class,'text')][contains(text(),'Начинки')]/..")
    private SelenideElement fillingScrollButton;
    public void clickFillingScroll() {
        fillingScrollButton.click();
    }

    //кнопка прокрутки до начинки, когда выполнена прокрутка до соуса (по нажатию, или через ручную прокрутку). Файндер получается каким то сложным
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current')]/span[contains(@class,'text')][contains(text(),'Начинки')]")
    private SelenideElement fillingScrollCurrentButton;
    public boolean waitFillingScrollCurrentButton(){
        fillingScrollCurrentButton.shouldBe(visible);
        return fillingScrollCurrentButton.exists();
    }

}
