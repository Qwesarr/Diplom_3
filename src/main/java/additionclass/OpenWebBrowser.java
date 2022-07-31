package additionclass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class OpenWebBrowser {
    public static void openPageSelector(String browser, String URL) {
        switch (browser) {
            case "Yandex":
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "D:\\Projects\\chromedriver.exe");
                options.setBinary("C:\\Users\\Qwesar\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                options.addArguments("test-type=browser");
                options.addArguments("chromeoptions.args", "--no-sandbox");
                options.addArguments("--window-size=1920,1080"); //Открывает страницу с определенным разрешением. Для драйвера.
                WebDriver driver = new ChromeDriver(options);
                WebDriverRunner.setWebDriver(driver);
                options.addArguments("--window-size=1920,1080");
            case "Chrome":{
                Configuration.browserSize = "1920x1080"; //Открывает страницу с определенным разрешением. Только для Хром.
            }

                open(URL);

        }
    }
}
