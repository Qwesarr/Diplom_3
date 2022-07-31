package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class AccountProfilePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //Кнопка "Выход" из аккаунта
    @FindBy(xpath = ".//button[contains(@class,'Account_button')][contains(text(),'Выход')]")
    private SelenideElement outLink;
    public void clickOutLink() {
        outLink.scrollTo().click();
    }

    //Ссылка "конструктор бургеров"
    @FindBy(xpath = ".//p[contains(@class,'AppHeader_header')][contains(text(),'Конструктор')]/..")
    private SelenideElement burgerDesignerLink;
    public void clickBurgerDesignerLink() {
        burgerDesignerLink.scrollTo().click();
    }

    //Ссылка баннер Stellar Burger
    @FindBy(xpath = ".//div[contains(@class,'AppHeader_header')]/a")
    private SelenideElement stellarBurgerLogoLink;
    public void clickStellarBurgerLogoLink() {
        stellarBurgerLogoLink.scrollTo().click();
    }

    //Кнопка "Сохранить"
    @FindBy(xpath = ".//button[contains(@class,'button_button')][contains(text(),'Сохранить')]")
    private SelenideElement saveButton;
    public boolean waitSaveButton(){
        saveButton.shouldBe(visible);
        return saveButton.exists();
    }

}
