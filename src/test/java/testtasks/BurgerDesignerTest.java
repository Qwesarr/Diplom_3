package testtasks;
import additionclass.OpenWebBrowser;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.HomePage;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerDesignerTest {
    private final HomePage homePage = page(HomePage.class);
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
        OpenWebBrowser.openPageSelector(browser, HomePage.URL);
    }

    @DisplayName("Проверяем прокрутку до булок {browser}")
    @Test
    public void scrollToBunTest() throws InterruptedException {
        homePage.clickSauceScroll();                                                                                    //Так как булки по дефолту выбраны, сначала прокрутим в низ.
        homePage.waitSauceScrollCurrentButton();
        homePage.clickBunsScrollButton();
        assertTrue(homePage.waitBunScrollCurrentButton());
    }

    @DisplayName("Проверяем прокрутку до соуса")
    @Test
    public void scrollToSauceTest() {
        homePage.clickSauceScroll();
        assertTrue(homePage.waitSauceScrollCurrentButton());
    }

    @DisplayName("Проверяем прокрутку до начинки")
    @Test
    public void scrollToFillingTest() {
        homePage.clickFillingScroll();
        assertTrue(homePage.waitFillingScrollCurrentButton());
    }

    @After
    public void clearData() {
        WebDriverRunner.getWebDriver().close();
    }
}
