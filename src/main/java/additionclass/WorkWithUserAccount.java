package additionclass;

import client.UserClient;
import dto.UserDto;
import lombok.extern.java.Log;
import pageobject.LoginPage;

import java.util.logging.Level;
import static com.codeborne.selenide.Selenide.page;

//Решил наследовать от UserClient, он в большем объеме используется в классе...
@Log
public class WorkWithUserAccount extends UserClient {
    private static LoginPage loginPage = page(LoginPage.class);

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
