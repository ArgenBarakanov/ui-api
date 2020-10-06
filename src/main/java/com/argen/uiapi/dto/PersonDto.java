package com.argen.uiapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonDto {

    private String name;

    private String lastName;

    private String about;
}
