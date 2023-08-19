package com.diana.insurance.controller;

import com.diana.insurance.controller.request.TransactionRequest;
import com.diana.insurance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/getAllByCustomerId")
    public String getAllByCustomerId(@RequestParam long customerId, Model model) {
        model.addAttribute("transactions", service.getAllByCustomerId(customerId));
        model.addAttribute("customer_Id", customerId);

        return "transaction/transaction-main-page";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam long customerId, Model model) {
        model.addAttribute("transaction", new TransactionRequest());
        model.addAttribute("customer_Id", customerId);

        return "transaction/transaction-create-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam long customerId, @ModelAttribute TransactionRequest request) {
        request.setCustomerId(customerId);
        service.save(request);

        return "redirect:/transaction/getAllByCustomerId?customerId=" + customerId;
    }


    @GetMapping("/deleteById")
    public String deleteById(@RequestParam long transactionId, @RequestParam long customerId) {
        service.deleteById(transactionId);

        return "redirect:/transaction/getAllByCustomerId?customerId=" + customerId;
    }
}
