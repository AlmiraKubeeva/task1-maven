package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class GettingClientsCardTest {
    private RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/cart");

    /*
    GET Request - get client's card
     */
    @Test
    public void getClientsCardTest() {
        reqSpec.get()
                .then().log().all().assertThat().statusCode(200);
    }
}
