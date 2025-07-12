
package com.cognizant.springlearn.model;

import javax.validation.constraints.*;

public class Department {
    @NotNull
    private Integer id;

    @NotNull @NotBlank @Size(min = 1, max = 30)
    private String name;

    // Getters and Setters omitted
}
