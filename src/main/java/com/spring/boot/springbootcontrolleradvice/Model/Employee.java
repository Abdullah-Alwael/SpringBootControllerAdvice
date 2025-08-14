package com.spring.boot.springbootcontrolleradvice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // why do we need this?
@Entity // turns it into a table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be empty")
    @Size(min = 2, message = "name must not be less than 2 characters")
    @Pattern(regexp = "^\\D+$", message = "name can not have numbers")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Positive(message = "salary must be a positive number")
    @NotNull(message = "salary can not be empty")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @NotNull(message = "isLeave can not be empty")
    @Column(columnDefinition = "boolean not null")
    private Boolean isLeave;

    @NotNull(message = "age can not be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
