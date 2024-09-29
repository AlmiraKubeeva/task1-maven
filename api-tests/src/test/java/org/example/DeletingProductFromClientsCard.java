package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Pages.CART;

public class DeletingProductFromClientsCard extends BaseTest {

    @BeforeEach
    public void before() {
        reqSpec.header("Authorization", "Bearer " + authToken)
                .body(new AddProduct(1, 2))
                .post(CART);
    }

    /*
    DELETE Request - delete product from client's card
    */
    @Test
    public void deleteAddedProductToClientsCardTest() {
        reqSpec.body(new AddProduct(1, 2))
                .delete(CART + "/1")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void deleteNotAddedProductToClientsCardTest() {
        String message = reqSpec.body(new AddProduct(0, 4))
                .delete(CART + "/0")
                .then().assertThat().statusCode(404)
                .extract().body().jsonPath().getString("message");
        Assertions.assertEquals("Product not found in cart", message);
    }
}
