package additionclass;

import client.RestAssuredClient;
import client.UserClient;
import dto.UserDto;
import pageobject.LoginPage;

import java.util.logging.Level;
import java.util.logging.Logger;
import static com.codeborne.selenide.Selenide.page;


public class WorkWithUserAccount extends UserClient {
    private static final LoginPage loginPage = page(LoginPage.class);
    static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void createUser(String name, String email, String password) {
        UserDto userDto = new UserDto(name,email,password);
        registration(userDto);
    }

    public void loginUser(String email, String password, String browser) {
        OpenWebBrowser.openPageSelector(browser, LoginPage.URL); //Выбор через что проверяем. "Yandex" или "Chrome"
        loginPage.loginClient(email, password);
        loginPage.clickLoginButton();
    }

    public void deleteUser(String email, String password) {

        try {
            delete(login(new UserDto(email, password)).path("accessToken"));
            }
        catch (NullPointerException e ) {
            // код, который выполнится, если произойдёт исключение AssertionError
            log.log(Level.WARNING,"Не удалось получить токен для пользователя " + email + ". " + e);
            }
        }
    }
