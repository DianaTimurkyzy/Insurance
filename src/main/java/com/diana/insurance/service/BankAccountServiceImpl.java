package com.diana.insurance.service;

import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.BankAccountRequest;
import com.diana.insurance.entity.BankAccount;
import com.diana.insurance.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository repository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankAccount getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(BankAccountRequest request) {
        if (repository.existsByAccountNumber(request.getBankAccountDTO().getAccountNumber())) {
            throw new ObjectAlreadyExistsException("Bank Account already exists");
        } else {
            BankAccount bankAccount = new BankAccount(
                    request.getBankAccountDTO().getAccountNumber(),
                    request.getBankAccountDTO().getName(),
                    request.getBankAccountDTO().getFunds(),
                    request.getBankAccountDTO().getOpeningDate(),
                    request.getBankAccountDTO().getCountry()
            );
            repository.save(bankAccount);
        }
    }

    @Override
    public void saveLogo(MultipartFile file, long id) {

        BankAccount bankAccount = repository.findById(id).get();

        try {
            bankAccount.setLogo(file.getBytes());
            repository.save(bankAccount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


}
