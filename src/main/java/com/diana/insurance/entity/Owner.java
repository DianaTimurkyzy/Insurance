package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SIN")
    private int sin;

    @Column(name = "COUNTRY_TAX_RESIDENT")
    private String country;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;


    public Owner() {
    }

    public Owner(String firstName, String lastName, String email, int sin, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sin = sin;
        this.country = country;
    }
}
