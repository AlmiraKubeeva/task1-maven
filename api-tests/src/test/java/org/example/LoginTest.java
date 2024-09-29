package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Pages.LOGIN;

public class LoginTest extends BaseTest {
    /*
    POST Request - client authorisation in app
     */
    @Test
    public void loginRegisteredUserTest() {
        reqSpec.body(new User("string", "string"))
                .post(LOGIN)
                .then().assertThat().statusCode(200);
    }

    @Test
    public void loginUnregisteredUserTest() {
        reqSpec.body(new User("notRegisteredUserstring", "string"))
                .post(LOGIN)
                .then().assertThat().statusCode(401);
    }

    @Test
    public void loginRegisteredUserWrongPasswordTest() {
        reqSpec.body(new User("string", "wrongPassword"))
                .post(LOGIN)
                .then().assertThat().statusCode(401);
    }

}
