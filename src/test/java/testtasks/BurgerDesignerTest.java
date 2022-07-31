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
    HomePage homePage = page(HomePage.class);
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
    public void scrollToBunTest() {
        homePage.clickFillingScroll();                   //Так как булки по дефолту сверху, сначала прокрутим в низ.
        homePage.clickBunsScrollButton();
        assertTrue(homePage.waitBunsInScrollTex());
    }

    @DisplayName("Проверяем прокрутку до соуса")
    @Test
    public void scrollToSauceTest() {
        homePage.clickSauceScroll();
        assertTrue(homePage.waitSauceInScrollText());
    }

    @DisplayName("Проверяем прокрутку до начинки")
    @Test
    public void scrollToFillingTest() {
        homePage.clickFillingScroll();
        assertTrue(homePage.waitFillingInScrollText());
    }

    @After
    public void clearData() {
        WebDriverRunner.getWebDriver().close();
    }
}
