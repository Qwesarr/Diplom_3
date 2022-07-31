package testtasks;
import additionclass.WorkWithUserAccount;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.*;
import precondition.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.page;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class PersonalAccountTest {
    AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
    LoginPage loginPage = page(LoginPage.class);
    HomePage homePage = page(HomePage.class);
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
        userAccount.loginUser(testData.getEmail(),testData.getPassword(),browser);
    }

    @DisplayName("Проверка перехода в личный кабинет с главной страницы")
    @Test
    public void loginAccountLinkTest() {
        homePage.clickPersonalAccountLink();
        assertTrue(accountProfilePage.waitSaveButton());
    }

    @DisplayName("Проверка перехода на главную страницу через сслыку 'Конструктор'")
    @Test
    public void burgerDesignerLinkTest() {
        homePage.clickPersonalAccountLink();
        accountProfilePage.clickBurgerDesignerLink();
        assertTrue(homePage.waitCreateOrderButton());
    }

    @DisplayName("Проверка перехода на главную страницу через баннер 'stellar burger'")
    @Test
    public void stellarBurgerLogoLinkTest() {
        homePage.clickPersonalAccountLink();
        accountProfilePage.clickStellarBurgerLogoLink();
        assertTrue(homePage.waitCreateOrderButton());
    }
    @DisplayName("Проверка выхода из аккаунта")
    @Test
    public void outButtonTest() {
        homePage.clickPersonalAccountLink();
        accountProfilePage.clickOutLink();
        assertTrue(loginPage.waitLoginButton());
    }

    //Пытаемся удалить созданного пользователя
    @After
    public void clearData() {
        userAccount.deleteUser(testData.getEmail(),testData.getPassword());
        WebDriverRunner.getWebDriver().close();
    }
}
