
package com.cognizant.springlearn.model;

import javax.validation.constraints.*;

public class Skill {
    @NotNull
    private Integer id;

    @NotNull @NotBlank @Size(min = 1, max = 30)
    private String name;

    // Getters and Setters omitted
}
