package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    //Поля имя, Email, пароль для регистрации
    @FindBy(xpath = ".//label[contains(@class,'input__placeholder')][contains(text(),'Имя')]/../input")
    private SelenideElement inputFieldName;
    @FindBy(xpath = ".//label[contains(@class,'input__placeholder')][contains(text(),'Email')]/../input")
    private SelenideElement inputFieldEmail;
    @FindBy(xpath = ".//label[contains(@class,'input__placeholder')][contains(text(),'Пароль')]/../input")
    private SelenideElement inputFieldPassword;
    public void newClientRegistration(String name, String email, String password) {
        inputFieldName.setValue(name);
        inputFieldEmail.setValue(email);
        inputFieldPassword.setValue(password);
    }

    //Кнопка регистрации
    @FindBy(xpath = ".//button[contains(@class,'button_button')][contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;
    public void clickRegistrationButton() {
        registrationButton.scrollTo().click();
    }

    //Текст сообщения с ошибкой регистрации
    @FindBy(xpath = ".//p[contains(@class, 'input__error')]")
    private SelenideElement registrationFailText;
    public String getRegistrationFailText()  {
        return registrationFailText.getText();
    }

    //Ссылка на вход в личный кабинет
    @FindBy(xpath = ".//a[contains(@class,'Auth_link')][contains(text(),'Войти')]")
    private SelenideElement authLinkEnter;
    public void clickAuthLinkEnter() {
        authLinkEnter.shouldBe(visible);
        authLinkEnter.scrollTo().click();
    }

}
