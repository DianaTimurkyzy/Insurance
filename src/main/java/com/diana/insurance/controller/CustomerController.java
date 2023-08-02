package com.diana.insurance.controller;

import com.diana.insurance.controller.request.CustomerRequest;
import com.diana.insurance.entity.Customer;
import com.diana.insurance.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public Customer getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid CustomerRequest request) {
        System.out.println(request.getCustomerDTO().isPaid() + "controller");
        service.save(request);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }

}
