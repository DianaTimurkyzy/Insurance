package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

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

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String name, int funds, LocalDate openingDate, String country) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.funds = funds;
        this.openingDate = openingDate;
        this.country = country;
    }
}
