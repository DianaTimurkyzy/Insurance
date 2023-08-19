package com.diana.insurance.service;

import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.BankRequest;
import com.diana.insurance.entity.Bank;
import com.diana.insurance.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository repository;

    @Autowired
    public BankServiceImpl(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Bank> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(BankRequest request) {
        if (repository.existsByRegistrationNumber(request.getBankDTO().getRegistrationNumber())) {
            throw new ObjectAlreadyExistsException("Bank already exists");
        } else {
            Bank bank = new Bank(
                    request.getBankDTO().getRegistrationNumber(),
                    request.getBankDTO().getName(),
                    request.getBankDTO().getFunds(),
                    request.getBankDTO().getOpeningDate(),
                    request.getBankDTO().getCountry()
            );
            repository.save(bank);
        }
    }

    @Override
    public void saveLogo(MultipartFile file, long id) {
        Bank bank = repository.findById(id).get();

        try {
            bank.setLogo(file.getBytes());
            repository.save(bank);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
