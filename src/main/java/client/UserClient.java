package client;

import dto.UserDto;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

public class UserClient extends RestAssuredClient {                                                                                               //Клас для работы с АПИ
    //private final RestAssuredClient restAssuredClient;

    public void delete(String token) {
        delete("auth/user", token.substring("Bearer ".length()));
    }

    public Response login(UserDto userDto) {
        return post("auth/login", userDto);
    }

    public void registration(UserDto createDto) {
        post("auth/register", createDto);
    }

}
