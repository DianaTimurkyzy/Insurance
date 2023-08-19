package com.diana.insurance.repository;

import com.diana.insurance.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    boolean existsByMonthAndCustomerId(String month, long customerId);

    List<Transaction> findAllByCustomer_Id(long id);

}
