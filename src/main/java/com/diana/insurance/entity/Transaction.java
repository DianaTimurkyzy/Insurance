package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "PAID_AT")
    private LocalDate paidAt;

    @Column(name = "AMOUNT_PAID")
    private int amountPaid;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    public Transaction() {
    }

    public Transaction(String month, LocalDate paidAt, int amountPaid) {
        this.month = month;
        this.paidAt = paidAt;
        this.amountPaid = amountPaid;
    }
}
