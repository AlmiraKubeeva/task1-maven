package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("category")
    String category;
    @JsonProperty("price")
    double price;
    @JsonProperty("discount")
    double discount;
    @JsonProperty("quantity")
    long quantity;

    public Product(int id, String name, String category, double price, double discount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

    public Product(String name, String category, double price, double discount) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

}
