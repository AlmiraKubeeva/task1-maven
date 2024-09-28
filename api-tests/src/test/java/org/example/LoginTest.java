package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTest {

   private RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/login");

    /*
    POST Request - client authorisation in app
     */
    @Test
    public void loginRegisteredUserTest() {
        reqSpec.body(new User("string", "string"))
                .post()
                .then().assertThat().statusCode(200);
    }

    @Test
    public void loginUnregisteredUserTest() {
        reqSpec.body(new User("notRegisteredUserstring", "string"))
                .post()
                .then().assertThat().statusCode(401);
    }

    @Test
    public void loginRegisteredUserWrongPasswordTest() {
        reqSpec.body(new User("string", "wrongPassword"))
                .post()
                .then().assertThat().statusCode(401);
    }

}
