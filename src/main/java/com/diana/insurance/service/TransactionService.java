package com.diana.insurance.service;

import com.diana.insurance.controller.request.TransactionRequest;
import com.diana.insurance.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllByCustomerId(long id);

    void save(TransactionRequest request);

    void deleteById(long id);
}
