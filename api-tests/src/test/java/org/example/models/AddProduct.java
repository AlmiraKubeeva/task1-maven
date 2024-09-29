package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class AddProduct {
    @JsonProperty("product_id")
    int id;
    int quantity;
}
