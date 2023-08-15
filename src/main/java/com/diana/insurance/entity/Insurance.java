package com.diana.insurance.entity;

import com.diana.insurance.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private InsuranceType insuranceType;

    @Column(name = "PRICE_PER_MONTH")
    private int pricePerMonth;

    @Column(name = "COVERAGE_PERCENTAGE")
    private int coveragePercentage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private BankAccount bankAccount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "insurance_customer",
            joinColumns = @JoinColumn(name = "INSURANCE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    private List<Customer> customers;


    public Insurance() {
    }

    public Insurance(InsuranceType insuranceType, int pricePerMonth, int coveragePercentage) {
        this.insuranceType = insuranceType;
        this.pricePerMonth = pricePerMonth;
        this.coveragePercentage = coveragePercentage;
    }

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
