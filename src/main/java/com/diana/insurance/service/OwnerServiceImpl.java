package com.diana.insurance.service;

import com.diana.insurance.controller.request.OwnerAndBankIdRequest;
import com.diana.insurance.entity.Bank;
import com.diana.insurance.entity.Owner;
import com.diana.insurance.repository.BankRepository;
import com.diana.insurance.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository repository;
    private final BankRepository bankRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository repository, BankRepository bankRepository) {
        this.repository = repository;
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Owner> getOwnersByBankId(long bankId) {
        return repository.findOwnersByBank_Id(bankId);
    }

    @Override
    @Transactional
    public void save(OwnerAndBankIdRequest request) {
        Bank bank = bankRepository.findById(request.getBankId()).get();
        Owner owner = new Owner(
                request.getOwnerDTO().getFirstName(),
                request.getOwnerDTO().getLastName(),
                request.getOwnerDTO().getEmail(),
                request.getOwnerDTO().getSin(),
                request.getOwnerDTO().getCountry()
        );
        owner.setBank(bank);
        repository.save(owner);
    }

    @Override
    public void deleteById(long id) {

        Owner owner = repository.findById(id).get();

        owner.setBank(null);

        repository.deleteById(id);
    }

}
