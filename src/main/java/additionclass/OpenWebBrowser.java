package additionclass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.open;

public class OpenWebBrowser {
    public static void openPageSelector(String browser, String URL) {
        switch (browser) {
            case "Yandex":
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                options.addArguments("test-type=browser", "chromeoptions.args", "--no-sandbox", "start-maximized");
                WebDriver driver = new ChromeDriver(options);
                WebDriverRunner.setWebDriver(driver);
            case "Chrome":{
                Configuration.browserSize = "1920x1080"; //Открывает страницу с определенным разрешением. Только для Хром.
            }
                open(URL);

        }
    }
}
