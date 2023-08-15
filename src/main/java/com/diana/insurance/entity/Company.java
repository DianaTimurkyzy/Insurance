package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "WEBSITE_URL")
    private String websiteUrl;

    @Column(name = "FOUNDATION_DATE")
    private LocalDate foundationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private BankAccount bankAccount;


    public Company() {
    }

    public Company(String name, String email, String websiteUrl, LocalDate foundationDate) {
        this.name = name;
        this.email = email;
        this.websiteUrl = websiteUrl;
        this.foundationDate = foundationDate;
    }
}
