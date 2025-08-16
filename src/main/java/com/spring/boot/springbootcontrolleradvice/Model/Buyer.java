package com.spring.boot.springbootcontrolleradvice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "age must not be empty")
    @Positive(message = "age must be a positive number")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "phone should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String phone;

    //email is optional
    @Column(columnDefinition = "varchar(30)")
    private String email;


}
