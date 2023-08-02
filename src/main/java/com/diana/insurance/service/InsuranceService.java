package com.diana.insurance.service;

import com.diana.insurance.controller.request.InsuranceRequest;
import com.diana.insurance.entity.Insurance;

import java.util.List;

public interface InsuranceService {

    Insurance getById(long id);

    List<Insurance> getAll();

    List<Insurance> getInsurancesByBankId(long id);

    void save(InsuranceRequest request);

    void deleteById(long id);
}
