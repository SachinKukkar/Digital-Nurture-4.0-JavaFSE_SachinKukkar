
package com.cognizant.springlearn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class Employee {
    @NotNull
    private Integer id;

    @NotNull @NotBlank @Size(min = 1, max = 30)
    private String name;

    @NotNull @Min(0)
    private Double salary;

    @NotNull
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull
    private Department department;

    private List<Skill> skillList;

    // Getters and Setters omitted for brevity
}
