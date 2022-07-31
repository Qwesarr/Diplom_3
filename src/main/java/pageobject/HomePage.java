package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Point;
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

    //Прокрутка до соуса
    @FindBy(xpath = ".//span[contains(@class,'text')][contains(text(),'Соусы')]/..")
    private SelenideElement sauceScrollButton;

    public void clickSauceScroll() {
        sauceScrollButton.click();
    }
    //Прокрутка до начинки
    @FindBy(xpath = ".//span[contains(@class,'text')][contains(text(),'Начинки')]/..")
    private SelenideElement fillingScrollButton;
    public void clickFillingScroll() {
        fillingScrollButton.click();
    }

    //Текст "Булки" в прокручиваемом списке
    @FindBy(xpath = ".//h2[contains(@class,'text')][contains(text(),'Булки')]")
    private SelenideElement bunsInScrollText;
    public Boolean waitBunsInScrollTex(){
        bunsInScrollText.shouldBe(visible);
        return bunsInScrollText.isDisplayed();
    }

    //Текст "Соусы" в прокручиваемом списке
    @FindBy(xpath = ".//h2[contains(@class,'text')][contains(text(),'Соусы')]")
    private SelenideElement sauceInScrollText;
    public Boolean waitSauceInScrollText(){
        sauceInScrollText.shouldBe(visible);
        return sauceInScrollText.isDisplayed();
    }

    //Текст "Начинки" в прокручиваемом списке
    @FindBy(xpath = ".//h2[contains(@class,'text')][contains(text(),'Начинки')]")
    private SelenideElement fillingInScrollText;
    public Boolean waitFillingInScrollText(){
        fillingInScrollText.shouldBe(visible);
        return fillingInScrollText.isDisplayed();
    }

}
