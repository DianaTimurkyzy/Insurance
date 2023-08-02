package com.diana.insurance.service;

import com.diana.insurance.controller.request.BankAccountRequest;
import com.diana.insurance.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccount getById(long id);

    List<BankAccount> getAll();

    void save(BankAccountRequest request);

    void deleteById(long id);

}
