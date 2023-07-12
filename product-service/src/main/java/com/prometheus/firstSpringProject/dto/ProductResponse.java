package com.prometheus.firstSpringProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
