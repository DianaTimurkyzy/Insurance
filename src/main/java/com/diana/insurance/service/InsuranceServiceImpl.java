package com.diana.insurance.service;

import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.InsuranceRequest;
import com.diana.insurance.entity.Bank;
import com.diana.insurance.entity.Insurance;
import com.diana.insurance.repository.BankRepository;
import com.diana.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository repository;
    private final BankRepository bankRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository repository, BankRepository bankRepository) {
        this.repository = repository;
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Insurance> getInsurancesByBankId(long id) {
        List<Insurance> insurances = repository.findAllByBank_Id(id);

        insurances.stream().forEach(insurance -> {
            insurance.setCustomers(null);
        });

        return insurances;
    }

    @Override
    public void save(InsuranceRequest request) {
        if (repository.existsByInsuranceTypeAndBankId(request.getInsuranceDTO().getInsuranceType(), request.getBankId())) {
            throw new ObjectAlreadyExistsException("Bank already has the Insurance type");
        } else {
            Bank bank = bankRepository.findById(request.getBankId()).get();
            Insurance insurance = new Insurance(
                    request.getInsuranceDTO().getInsuranceType(),
                    request.getInsuranceDTO().getPricePerMonth(),
                    request.getInsuranceDTO().getCoveragePercentage()
            );
            insurance.setBank(bank);
            repository.save(insurance);
        }
    }

    @Override
    public void deleteById(long id) {

        Insurance insurance = repository.findById(id).get();

        insurance.setBank(null);

        repository.delete(insurance);
    }

}
