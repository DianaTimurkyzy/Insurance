package com.diana.insurance.service;

import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.InsuranceRequest;
import com.diana.insurance.entity.BankAccount;
import com.diana.insurance.entity.Insurance;
import com.diana.insurance.repository.BankAccountRepository;
import com.diana.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository repository;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository repository, BankAccountRepository bankAccountRepository) {
        this.repository = repository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Insurance getById(long id) {
        Insurance insurance = repository.findById(id).get();

        insurance.setCustomers(null);

        return insurance;
    }

    @Override
    public List<Insurance> getAll() {

        List<Insurance> insurances = repository.findAll();

        insurances.forEach(insurance -> {
            insurance.setCustomers(null);
        });

        return insurances;
    }

    @Override
    public List<Insurance> getInsurancesByBankId(long id) {
        List<Insurance> insurances = repository.findAllByBankAccount_Id(id);

        insurances.stream().forEach(insurance -> {
            insurance.setCustomers(null);
        });

        return insurances;
    }

    @Override
    public void save(InsuranceRequest request) {
        if (repository.existsByInsuranceTypeAndBankAccountId(request.getInsuranceDTO().getInsuranceType(), request.getBankAccountId())) {
            throw new ObjectAlreadyExistsException("Bank already has the Insurance type");
        } else {
            BankAccount bankAccount = bankAccountRepository.findById(request.getBankAccountId()).get();
            Insurance insurance = new Insurance(
                    request.getInsuranceDTO().getInsuranceType(),
                    request.getInsuranceDTO().getPricePerMonth(),
                    request.getInsuranceDTO().getCoveragePercentage()
            );
            insurance.setBankAccount(bankAccount);
            repository.save(insurance);
        }
    }

    @Override
    public void deleteById(long id) {

        Insurance insurance = repository.findById(id).get();

        insurance.setBankAccount(null);

        repository.delete(insurance);
    }

}
