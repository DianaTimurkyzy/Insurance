package com.diana.insurance.repository;

import com.diana.insurance.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    boolean existsByRegistrationNumber(String registrationNumber);

}