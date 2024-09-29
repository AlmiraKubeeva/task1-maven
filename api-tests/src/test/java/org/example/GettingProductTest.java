package org.example;

import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.Pages.PRODUCTS;

public class GettingProductTest extends BaseTest {
    /*
    GET Request - get list of products
     */
    @Test
    public void getProductsListTest() {
        reqSpec.get(PRODUCTS)
                .then().assertThat().statusCode(200)
                .extract().as(new TypeRef<List<Product>>() {});
    }

    @Test
    public void getProductByIdTest() {
        reqSpec.get(PRODUCTS + "/1")
                .then().assertThat().statusCode(200)
                .extract().as(new TypeRef<List<Product>>() {});

    }

    @Test
    public void getNonExistingProductTest() {
        String message = reqSpec.get(PRODUCTS + "/0")
                .then().assertThat().statusCode(404)
                .extract().body().jsonPath().getString("message");
        Assertions.assertEquals("Product not found", message);
    }

}
