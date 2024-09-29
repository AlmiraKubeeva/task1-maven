package org.example;

import io.restassured.RestAssured;
import org.example.models.AddProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.constants.Pages.CART;

public class AddingProductToClientsCardTest extends BaseTest {
    /*
    POST Request - adding product to client's card
     */

    @Test
    public void addExistingProductToClientsCardTest() {
        reqSpec.header("Authorization", "Bearer " + authToken)
                .body(new AddProduct(1, 2))
                .post(CART)
                .then().assertThat().statusCode(201);
    }

    @Test
    public void addNonExistingProductToClientsCardTest() {
        String message = reqSpec.header("Authorization", "Bearer " + authToken)
                .body(new AddProduct(0, 4))
                .post(CART)
                .then().assertThat().statusCode(404)
                .extract().body().jsonPath().getString("message");
        Assertions.assertEquals("Product not found", message);
    }

    @Test
    public void addExistingProductToClientsCardIfUserIsNotAuthorizedTest() {
        RestAssured.given()
                .contentType("application/json")
                .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/cart")
                .body(new AddProduct(1, 2))
                .post()
                .then().assertThat().statusCode(401);
    }
}
