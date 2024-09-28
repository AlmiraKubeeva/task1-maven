package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class AddingProductToClientsCardTest {
    RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/cart");
    /*
    POST Request - adding product to client's card
     */
    @Test
    public void addExistingProductToClientsCardTest() {

    }

    @Test
    public void addNonExistingProductToClientsCardTest() {

    }

    @Test
    public void addExistingProductToClientsCardIfUserIsNotAuthorizedTest() {

    }
}
