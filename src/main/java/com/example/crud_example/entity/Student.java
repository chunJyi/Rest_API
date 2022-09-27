package com.example.crud_example.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    @NotNull(message = "first Name is not null")
    private String firstName;
    @Column(nullable = false)
    @NotNull(message = "last Name is not null")
    private String lastName;
    @NotNull(message = "email is not null")
    private String email;
    @Column(nullable = false,unique = true)
    private String phNo;

}
