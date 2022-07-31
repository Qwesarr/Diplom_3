package testtasks;

import additionclass.WorkWithUserAccount;
import additionclass.OpenWebBrowser;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.ForgotPasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import precondition.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class LoginValidTest {
    LoginPage loginPage = page(LoginPage.class);
    HomePage homePage = page(HomePage.class);
    ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class );
    RegisterPage registerPage = page(RegisterPage.class);
    WorkWithUserAccount userAccount = new WorkWithUserAccount();
    TestData testData = new TestData();
    //Запускаем проверку на Chrome и Yandex
    @Parameterized.Parameter
    public String browser;
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Chrome"},
                {"Yandex"},
        };
    }


    @Before
    public void openPage() {
        userAccount.createUser(testData.getName(),testData.getEmail(),testData.getPassword());
    }

    @DisplayName("Выполняем вход через кнопку 'Войти в аккаунт' с главной страницы")
    @Test
    public void loginFromHomePageEnterAccountButton() {
        OpenWebBrowser.openPageSelector(browser, HomePage.URL);
        homePage.clickLoginButton();
        loginPage.loginClient(testData.getEmail(),testData.getPassword());
        loginPage.clickLoginButton();
        assertTrue(homePage.waitCreateOrderButton());
    }

    @DisplayName("Выполняем вход через кнопку 'Личный кабинет' с главной страницы")
    @Test
    public void loginFromHomePagePersonalAccountButton() {
        OpenWebBrowser.openPageSelector(browser, HomePage.URL);
        homePage.clickPersonalAccountLink();
        loginPage.loginClient(testData.getEmail(),testData.getPassword());
        loginPage.clickLoginButton();
        assertTrue(homePage.waitCreateOrderButton());
    }
    @DisplayName("Выполняем вход со страницы регистрации")
    @Test
    public void loginFromForgotPasswordPageEnterLink() {
        OpenWebBrowser.openPageSelector(browser, RegisterPage.URL);
        registerPage.clickAuthLinkEnter();
        loginPage.loginClient(testData.getEmail(),testData.getPassword());
        loginPage.clickLoginButton();
        assertTrue(homePage.waitCreateOrderButton());
    }

    @DisplayName("Выполняем вход со страницы восстановления пароля")
    @Test
    public void loginFromRegistrationPageEnterLink() {
        OpenWebBrowser.openPageSelector(browser, ForgotPasswordPage.URL);
        forgotPasswordPage.clickAuthLinkEnter();
        loginPage.loginClient(testData.getEmail(),testData.getPassword());
        loginPage.clickLoginButton();
        assertTrue(homePage.waitCreateOrderButton());
    }

    //Пытаемся удалить созданного пользователя
    @After
    public void clearData() {
        userAccount.deleteUser(testData.getEmail(),testData.getPassword());
        WebDriverRunner.getWebDriver().close();
    }
}
