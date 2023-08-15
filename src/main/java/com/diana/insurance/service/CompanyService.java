package com.diana.insurance.service;

import com.diana.insurance.controller.request.CompanyAndBankAccountIdRequest;
import com.diana.insurance.controller.request.CompanyAndBankAccountRequest;
import com.diana.insurance.entity.Company;

import java.util.List;

public interface CompanyService {

    Company getById(long id);

    List<Company> getAll();

    void save(CompanyAndBankAccountIdRequest request);

    void saveWithBankAccount(CompanyAndBankAccountRequest request);

    void deleteById(long id);
}
