package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class DeletingProductFromClientsCard {
    RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/cart");
    /*
    DELETE Request - delete product from client's card
     */
    @Test
    public void deleteAddedProductToClientsCardTest() {

    }

    @Test
    public void deleteNotAddedProductToClientsCardTest() {

    }
}
