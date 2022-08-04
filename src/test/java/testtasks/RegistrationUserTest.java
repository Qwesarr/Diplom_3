package testtasks;
import additionclass.WorkWithUserAccount;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import additionclass.OpenWebBrowser;
import precondition.TestData;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationUserTest {
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final WorkWithUserAccount userAccount = new WorkWithUserAccount();
    private static final TestData testData = new TestData();
    private static final String errorText = "Некорректный пароль";

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
        OpenWebBrowser.openPageSelector(browser, RegisterPage.URL); //Выбор через что проверяем. "Yandex" или "Chrome"
    }

    //Создаем нового пользователя
    @DisplayName("Успешно создаем нового пользователя для сайта")
    @Test
    public void successfullyCreateNewUserTest() {
        registerPage.newClientRegistration(testData.getName(),testData.getEmail(),testData.getPassword());
        registerPage.clickRegistrationButton();
        assertTrue(loginPage.waitForLoginText());
    }

    @DisplayName("Попытка создания нового пользователя с коротким паролем")
    @Test
    public void createNewUserWithIncorrectPasswordTest() {
        registerPage.newClientRegistration(testData.getName(),testData.getEmail(),testData.getShortPassword());
        registerPage.clickRegistrationButton();
        assertEquals(errorText,registerPage.getRegistrationFailText());
    }


    @After
    public void clearData() {
        WebDriverRunner.getWebDriver().close();
        userAccount.deleteUser(testData.getEmail(),testData.getPassword());
    }
}
