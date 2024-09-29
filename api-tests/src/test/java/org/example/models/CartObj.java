package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartObj {
    private List<Product> cart;

    @JsonProperty("total_price")
    private double totalPrice;

    @JsonProperty("total_discount")
    private double totalDiscount;

    public CartObj(List<Product> cart, double totalPrice, double totalDiscount) {
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
    }

    public CartObj() {}
}
