package com.diana.insurance.repository;

import com.diana.insurance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsBySinAndInsurances_Id(int sin, long insuranceId);
}
