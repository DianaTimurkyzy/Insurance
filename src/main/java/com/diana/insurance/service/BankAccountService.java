package com.diana.insurance.service;

import com.diana.insurance.controller.request.BankAccountRequest;
import com.diana.insurance.entity.BankAccount;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BankAccountService {

    BankAccount getById(long id);

    List<BankAccount> getAll();

    void save(BankAccountRequest request);

    void saveLogo(MultipartFile file, long id);

    void deleteById(long id);


}
