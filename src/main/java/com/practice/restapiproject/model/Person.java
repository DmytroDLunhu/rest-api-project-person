package com.practice.restapiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * JavaBean domain object.
 */
@jakarta.persistence.Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
public class Person extends Entity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;
}
