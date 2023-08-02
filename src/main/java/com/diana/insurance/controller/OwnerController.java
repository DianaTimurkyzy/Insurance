package com.diana.insurance.controller;

import com.diana.insurance.controller.request.OwnerAndBankAccountIdRequest;
import com.diana.insurance.controller.request.OwnerAndBankAccountRequest;
import com.diana.insurance.entity.Owner;
import com.diana.insurance.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService service;

    @Autowired
    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public Owner getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Owner> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid OwnerAndBankAccountIdRequest request) {
        service.save(request);
    }

    @PostMapping("/saveWithBankAccount")
    public void saveWithBankAccount(@RequestBody @Valid OwnerAndBankAccountRequest request) {
        service.saveWithBankAccount(request);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {


        service.deleteById(id);
    }

}
