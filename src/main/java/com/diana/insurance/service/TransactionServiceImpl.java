package com.diana.insurance.service;


import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.TransactionRequest;
import com.diana.insurance.entity.Customer;
import com.diana.insurance.entity.Transaction;
import com.diana.insurance.repository.CustomerRepository;
import com.diana.insurance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CustomerRepository customerRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Transaction getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Transaction> getAll() {
        List<Transaction> transactions = repository.findAll();

        transactions.stream().forEach(transaction -> {
            transaction.setCustomer(null);
        });

        return transactions;
    }

    @Override
    public void save(TransactionRequest request) {
        if (repository.existsByMonthAndCustomerId(request.getTransactionDTO().getMonth(), request.getCustomerId())) {
            throw new ObjectAlreadyExistsException("Customer already has transaction for this month");
        } else {
            Customer customer = customerRepository.findById(request.getCustomerId()).get();
            Transaction transaction = new Transaction(
                    request.getTransactionDTO().getMonth(),
                    request.getTransactionDTO().getPaidAt(),
                    request.getTransactionDTO().getAmountPaid()
            );
            transaction.setCustomer(customer);
            repository.save(transaction);

        }
    }

    @Override
    public void deleteById(long id) {

        Transaction transaction = repository.findById(id).get();

        transaction.setCustomer(null);

        repository.deleteById(id);
    }
}
