package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Ссылка на вход в личный кабинет
    @FindBy(xpath = ".//a[contains(@class,'Auth_link')][contains(text(),'Войти')]")
    private SelenideElement authLinkEnter;
    public void clickAuthLinkEnter() {
        authLinkEnter.scrollTo().click();
    }
}
