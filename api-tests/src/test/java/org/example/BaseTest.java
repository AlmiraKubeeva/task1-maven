package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static org.example.Pages.CART;
import static org.example.Pages.LOGIN;

public class BaseTest {

    protected RequestSpecification reqSpec = RestAssured.given()
            .contentType("application/json")
            .baseUri("http://9b142cdd34e.vps.myjino.ru:49268");;
    protected String authToken;

    @BeforeEach
    public void setup() {
        // Выполняем авторизацию и получаем токен
        authToken = reqSpec
                .body("{ \"username\": \"string\", \"password\": \"string\" }")
                .post(LOGIN)
                .jsonPath().getString("access_token");
        System.out.println(authToken);

        // Создаем базовую спецификацию с авторизацией
        /*
        reqSpec = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + authToken);*/
    }
    /*
    public void login() {
        authToken = reqSpec
                .body("{ \"username\": \"string\", \"password\": \"string\" }")
                .post(LOGIN)
                .jsonPath().getString("access_token");
    }
    public void authorization() {
        reqSpec.header("Authorization", "Bearer " + authToken);
    }*/
/*
    public void addProduct(Product product) {
        reqSpec.body(product)
                .post(CART);
    }*/

    /*
    // Метод для установки базового URI
    protected void setBaseUri(String baseUri) {
        reqSpec.baseUri(baseUri);
    }*/
}