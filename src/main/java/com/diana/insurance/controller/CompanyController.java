package com.diana.insurance.controller;

import com.diana.insurance.controller.request.CompanyAndBankAccountIdRequest;
import com.diana.insurance.controller.request.CompanyAndBankAccountRequest;
import com.diana.insurance.entity.Company;
import com.diana.insurance.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public Company getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Company> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid CompanyAndBankAccountIdRequest request) {
        service.save(request);
    }

    @PostMapping("/saveWithBankAccount")
    public void saveWithBankAccount(@RequestBody @Valid CompanyAndBankAccountRequest request) {
        service.saveWithBankAccount(request);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {


        service.deleteById(id);
    }

}
