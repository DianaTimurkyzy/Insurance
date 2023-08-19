package com.diana.insurance.controller;

import com.diana.insurance.controller.request.CustomerRequest;
import com.diana.insurance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/getAllByInsuranceId")
    public String getAllByInsuranceId(@RequestParam long insuranceId, Model model) {
        model.addAttribute("customers", service.getAllByInsuranceId(insuranceId));
        model.addAttribute("insurance_Id", insuranceId);

        return "customer/customer-main-page";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam long insuranceId, Model model) {
        model.addAttribute("customer", new CustomerRequest());
        model.addAttribute("insurance_Id", insuranceId);

        return "customer/customer-create-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam long insuranceId, @ModelAttribute CustomerRequest request) {
        request.setInsuranceId(insuranceId);
        service.save(request);

        return "redirect:/customer/getAllByInsuranceId?insuranceId=" + insuranceId;
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam long customerId, @RequestParam long insuranceId) {
        service.deleteById(customerId);

        return "redirect:/customer/getAllByInsuranceId?insuranceId=" + insuranceId;
    }

}
