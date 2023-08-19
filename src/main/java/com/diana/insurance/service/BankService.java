package com.diana.insurance.service;

import com.diana.insurance.controller.request.BankRequest;
import com.diana.insurance.entity.Bank;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BankService {

    List<Bank> getAll();

    void save(BankRequest request);

    void saveLogo(MultipartFile file, long id);

    void deleteById(long id);


}
