package com.diana.insurance.service;

import com.diana.insurance.controller.request.CompanyAndBankAccountIdRequest;
import com.diana.insurance.controller.request.CompanyAndBankAccountRequest;
import com.diana.insurance.entity.BankAccount;
import com.diana.insurance.entity.Company;
import com.diana.insurance.repository.BankAccountRepository;
import com.diana.insurance.repository.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository, BankAccountRepository bankAccountRepository) {
        this.repository = repository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Company getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(CompanyAndBankAccountIdRequest request) {
        BankAccount bankAccount = bankAccountRepository.findById(request.getBankAccountId()).get();
        System.out.println(request);
        Company company = new Company(
                request.getCompanyDTO().getName(),
                request.getCompanyDTO().getEmail(),
                request.getCompanyDTO().getWebsiteUrl(),
                request.getCompanyDTO().getFoundationDate()
        );
        company.setBankAccount(bankAccount);
        System.out.println(request);
        repository.save(company);
    }

    @Override
    @Transactional
    public void saveWithBankAccount(@RequestBody @Valid CompanyAndBankAccountRequest request) {
        BankAccount bankAccount = new BankAccount(
                request.getBankAccountDTO().getAccountNumber(),
                request.getBankAccountDTO().getName(),
                request.getBankAccountDTO().getFunds(),
                request.getBankAccountDTO().getOpeningDate(),
                request.getBankAccountDTO().getCountry());
        BankAccount bankAccountWithPK = bankAccountRepository.save(bankAccount);
        Company company = new Company(
                request.getCompanyDTO().getName(),
                request.getCompanyDTO().getEmail(),
                request.getCompanyDTO().getWebsiteUrl(),
                request.getCompanyDTO().getFoundationDate()
        );
        company.setBankAccount(bankAccountWithPK);
        repository.save(company);
    }

    @Override
    public void deleteById(long id) {

        Company company = repository.findById(id).get();

        company.setBankAccount(null);

        repository.deleteById(id);
    }

}
