package com.diana.insurance.controller;

import com.diana.insurance.controller.request.BankAccountRequest;
import com.diana.insurance.entity.BankAccount;
import com.diana.insurance.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    private final BankAccountService service;

    @Autowired
    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public BankAccount getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<BankAccount> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid BankAccountRequest request) {
        service.save(request);
    }

    @PostMapping("/saveLogo")
    public void save(@RequestParam MultipartFile file, @RequestParam long id) {
        service.saveLogo(file, id);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }
}
