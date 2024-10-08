package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.example.models.User;
import org.junit.jupiter.api.BeforeEach;

import static org.example.constants.Pages.LOGIN;

public class BaseTest {

    public String authToken;
    protected RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268");

    @BeforeEach
    public void setup() {
        authToken = reqSpec
                .body(new User("string", "string"))
                .post(LOGIN)
                .jsonPath().getString("access_token");
    }
}