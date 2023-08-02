package com.diana.insurance.service;

import com.diana.insurance.controller.request.OwnerAndBankAccountIdRequest;
import com.diana.insurance.controller.request.OwnerAndBankAccountRequest;
import com.diana.insurance.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner getById(long id);

    List<Owner> getAll();

    void save(OwnerAndBankAccountIdRequest request);

    void saveWithBankAccount(OwnerAndBankAccountRequest request);

    void deleteById(long id);
}
