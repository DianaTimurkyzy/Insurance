package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "owner")
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
    private String countryTaxResident;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ACC_ID")
    private BankAccount bankAccount;


    public Owner() {
    }

    public Owner(String firstName, String lastName, String email, int sin, String countryTaxResident) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sin = sin;
        this.countryTaxResident = countryTaxResident;
    }
}
