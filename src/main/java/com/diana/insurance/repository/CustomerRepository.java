package com.diana.insurance.repository;

import com.diana.insurance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsBySinAndInsurances_Id(int sin, long insuranceId);

    List<Customer> findAllByInsurances_Id(long id);
}
