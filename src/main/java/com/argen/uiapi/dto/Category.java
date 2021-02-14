package com.argen.uiapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Category {

    private String name;

    private List<Product> products;
}
