package com.diana.insurance.controller;

import com.diana.insurance.controller.request.TransactionRequest;
import com.diana.insurance.entity.Transaction;
import com.diana.insurance.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/getById")
    public Transaction getById(@RequestParam long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid TransactionRequest request) {
        service.save(request);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }
}
