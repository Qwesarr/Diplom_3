package client;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {                                                                                        //Клас для работы с АПИ
    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .setBaseUri("https://stellarburgers.nomoreparties.site/")
            .setBasePath("/api/")
            .build();

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
    public <T> Response post(String path, T body, Object... pathParams) {
        return given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post(path, pathParams);
    }

    public Response delete(String path, String token) {
        return given()
                .spec(getRequestSpecification())
                .when()
                .auth()
                .oauth2(token)
                .delete(path);
    }

}
