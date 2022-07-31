package client;

import dto.UserDto;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

public class UserClient {                                                                                               //Клас для работы с АПИ
    private final RestAssuredClient restAssuredClient;

    public UserClient(RestAssuredClient restAssuredClient) {
        this.restAssuredClient = restAssuredClient;
    }

    public Response delete(@NotNull String token) {
        return restAssuredClient.delete("auth/user", token.substring("Bearer ".length()));
    }

    public Response login(UserDto userDto) {
        return restAssuredClient.post("auth/login", userDto);
    }

    public Response registration(UserDto createDto) {
        return restAssuredClient.post("auth/register", createDto);
    }

}
