package org.example;

import org.example.Models.CartObj;
import org.junit.jupiter.api.Test;

import static org.example.constants.Pages.CART;

public class GettingClientsCardTest extends BaseTest {

    @Test
    public void getClientsCardTest() {
        reqSpec.header("Authorization", "Bearer " + authToken).log().all().get(CART)
                .then().assertThat().statusCode(200)
                .extract().as(CartObj.class);
    }
}