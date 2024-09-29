package org.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    int id;

    String name;
    String category;
    double price;
    double discount;
    int quantity;
}
