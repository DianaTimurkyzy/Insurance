package com.diana.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "SIN")
    private int sin;

    @Column(name = "IS_PAID")
    private boolean isPaid;

    @Column(name = "SIGNING_DATE")
    private LocalDate signingDate;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(
            name = "insurance_customer",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSURANCE_ID")
    )
    private List<Insurance> insurances;


    public Customer() {
    }

    public Customer(int sin, boolean isPaid, LocalDate signingDate) {
        this.sin = sin;
        this.isPaid = isPaid;
        this.signingDate = signingDate;
    }

    public void addInsurance(Insurance insurance) {
        if (insurances == null) {
            insurances = new ArrayList<>();
        }
        insurances.add(insurance);
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }
}
