package com.diana.insurance.service;

import com.diana.insurance.controller.request.OwnerAndBankAccountIdRequest;
import com.diana.insurance.controller.request.OwnerAndBankAccountRequest;
import com.diana.insurance.entity.BankAccount;
import com.diana.insurance.entity.Owner;
import com.diana.insurance.repository.BankAccountRepository;
import com.diana.insurance.repository.OwnerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository repository;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository repository, BankAccountRepository bankAccountRepository) {
        this.repository = repository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Owner getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Owner> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(OwnerAndBankAccountIdRequest request) {
        BankAccount bankAccount = bankAccountRepository.findById(request.getBankAccId()).get();
        Owner owner = new Owner(
                request.getOwnerDTO().getFirstName(),
                request.getOwnerDTO().getLastName(),
                request.getOwnerDTO().getEmail(),
                request.getOwnerDTO().getSin(),
                request.getOwnerDTO().getCountryTaxResident()
        );
        owner.setBankAccount(bankAccount);
        repository.save(owner);
    }

    @Override
    @Transactional
    public void saveWithBankAccount(@RequestBody @Valid OwnerAndBankAccountRequest request) {
        BankAccount bankAccount = new BankAccount(
                request.getBankAccountDTO().getAccountNumber(),
                request.getBankAccountDTO().getName(),
                request.getBankAccountDTO().getFunds(),
                request.getBankAccountDTO().getOpeningDate(),
                request.getBankAccountDTO().getCountry());
        BankAccount bankWithPK = bankAccountRepository.save(bankAccount);
        Owner owner = new Owner(
                request.getOwnerDTO().getFirstName(),
                request.getOwnerDTO().getLastName(),
                request.getOwnerDTO().getEmail(),
                request.getOwnerDTO().getSin(),
                request.getOwnerDTO().getCountryTaxResident()
        );
        owner.setBankAccount(bankWithPK);
        repository.save(owner);
    }

    @Override
    public void deleteById(long id) {

        Owner owner = repository.findById(id).get();

        owner.setBankAccount(null);

        repository.deleteById(id);
    }

}
