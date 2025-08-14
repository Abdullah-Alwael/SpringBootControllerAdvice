package com.spring.boot.springbootcontrolleradvice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coffee {

    // @Id = primary key in DB
    @Id
    // Identity is the preferred auto generation to make it
    // ok to use the same id between different tables
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, message = "name shall not be less than 2 characters")
    // use sql in column definition:
    @Column(columnDefinition = "Varchar(30) not null")
    private String name;

    @NotEmpty(message = "category should not be empty")
    @Column(columnDefinition = "Varchar(30) not null")
    private String category;

    @NotNull(message = "price should not be empty")
    @Column(columnDefinition = "int not null default 0")
    private Integer price;

    @NotNull(message = "empId can not be empty")
    @Column(columnDefinition = "int not null")
    private Integer empId; // do not add underscore _

}
