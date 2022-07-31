package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Надпись вход, на экране
    @FindBy(xpath = ".//div[contains(@class,'Auth_login')]/h2[contains(text(),'Вход')]")
    private SelenideElement loginText;
    public boolean waitForLoginText(){
        loginText.shouldBe(visible);
        return loginText.exists();
    }

    //Строка ввода Email
    @FindBy(xpath = ".//label[contains(@class,'input__placeholder')][contains(text(),'Email')]/../input")
    private SelenideElement inputFieldEmail;
    //Строка ввода пароля
    @FindBy(xpath = ".//label[contains(@class,'input__placeholder')][contains(text(),'Пароль')]/../input")
    private SelenideElement inputFieldPassword;
    public void loginClient(String email, String password) {
        inputFieldEmail.setValue(email);
        inputFieldPassword.setValue(password);
    }

    //кнопка входа
    @FindBy(xpath = ".//button[contains(@class,'button_button')]")
    private SelenideElement loginButton;
    public void clickLoginButton() {
        loginButton.scrollTo().click();
    }
    public boolean waitLoginButton(){
        loginButton.shouldBe(visible);
        return loginButton.exists();
    }

}
