package additionclass;

import client.RestAssuredClient;
import client.UserClient;
import dto.UserDto;
import pageobject.LoginPage;
import static com.codeborne.selenide.Selenide.page;


public class WorkWithUserAccount {
    private static UserClient userClient;
    LoginPage loginPage = page(LoginPage.class);


    public void createUser(String name, String email, String password) {
        userClient = new UserClient(new RestAssuredClient());
        UserDto userDto = new UserDto(name,email,password);
        userClient.registration(userDto);
    }

    public void loginUser(String email, String password, String browser) {
        OpenWebBrowser.openPageSelector(browser, LoginPage.URL); //Выбор через что проверяем. "Yandex" или "Chrome"
        loginPage.loginClient(email, password);
        loginPage.clickLoginButton();
    }

    public void deleteUser(String email, String password) throws NullPointerException {
        userClient = new UserClient(new RestAssuredClient());
        try{
            userClient.delete(userClient.login(new UserDto(email, password)).                                           //Удаляем пользователя в конце теста
                    then().
                    statusCode(200).
                    extract().
                    path("accessToken"));}
        catch (AssertionError exception) {
            System.out.println("Пользователь не создан, нечего удалять");                                               // код, который выполнится, если произойдёт исключение AssertionError
             }
        }
    }
