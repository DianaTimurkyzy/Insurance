package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FUNDS")
    private int funds;

    @Column(name = "OPENING_DATE")
    private LocalDate openingDate;

    @Column(name = "COUNTRY")
    private String country;

    @Lob
    @Column(name = "LOGO")
    private byte[] logo;

    public Bank() {
    }

    public Bank(String registrationNumber, String name, int funds, LocalDate openingDate, String country) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.funds = funds;
        this.openingDate = openingDate;
        this.country = country;
    }
}
