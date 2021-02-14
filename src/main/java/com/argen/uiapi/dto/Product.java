package com.argen.uiapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Product {
    private String title;
    private Double price;
    private String imageSrcUrl;
}
