package com.diana.insurance.controller;

import com.diana.insurance.controller.request.InsuranceRequest;
import com.diana.insurance.entity.Insurance;
import com.diana.insurance.service.InsuranceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService service;

    @Autowired
    public InsuranceController(InsuranceService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public Insurance getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Insurance> getAll() {
        return service.getAll();
    }

    @GetMapping("/getAllByBankId")
    public List<Insurance> getInsurancesByBankId(@RequestParam long id) {
        return service.getInsurancesByBankId(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid InsuranceRequest request) {
        service.save(request);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }
}
