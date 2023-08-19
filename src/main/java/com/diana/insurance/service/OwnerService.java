package com.diana.insurance.service;

import com.diana.insurance.controller.request.OwnerAndBankIdRequest;
import com.diana.insurance.entity.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getOwnersByBankId(long bankId);

    void save(OwnerAndBankIdRequest request);

    void deleteById(long id);
}
