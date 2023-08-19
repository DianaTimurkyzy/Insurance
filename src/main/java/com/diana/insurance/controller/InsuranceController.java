package com.diana.insurance.controller;

import com.diana.insurance.controller.request.InsuranceRequest;
import com.diana.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService service;

    @Autowired
    public InsuranceController(InsuranceService service) {
        this.service = service;
    }


    @GetMapping("/getAllByBankId")
    public String getAllByBankId(@RequestParam long bankId, Model model) {
        model.addAttribute("insurances", service.getInsurancesByBankId(bankId));
        model.addAttribute("bank_Id", bankId);

        return "insurance/insurance-main-page";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam long bankId, Model model) {
        model.addAttribute("insurance", new InsuranceRequest());
        model.addAttribute("bank_Id", bankId);

        return "insurance/insurance-create-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam long bankId, @ModelAttribute("insurance") InsuranceRequest request) {
        request.setBankId(bankId);
        service.save(request);


        return "redirect:/insurance/getAllByBankId?bankId=" + bankId;
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam long insuranceId, @RequestParam long bankId) {
        service.deleteById(insuranceId);

        return "redirect:/insurance/getAllByBankId?bankId=" + bankId;
    }
}
