package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class GettingProductTest {
    private RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268/products");

    /*
    GET Request - get list of products
     */
    @Test
    public void getProductsListTest() {
        reqSpec.get()
                .then().assertThat().statusCode(200);
    }

    @Test
    public void getProductByIdTest() {
        reqSpec.get("/1")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void getNonExistingProductTest() {
        reqSpec.get("/-1")
                .then().assertThat().statusCode(404);
    }

}
