package com.diana.insurance.service;

import com.diana.insurance.controller.request.TransactionRequest;
import com.diana.insurance.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getById(long id);

    List<Transaction> getAll();

    void save(TransactionRequest request);

    void deleteById(long id);
}
