package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Pages.CART;

public class GettingClientsCardTest extends BaseTest {

    @Test
    public void getClientsCardTest() {
        System.out.println(CartObj.class);
        reqSpec.header("Authorization", "Bearer " + authToken).log().all().get(CART)
                .then().assertThat().statusCode(200)
                .extract().as(CartObj.class);
    }
}