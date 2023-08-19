package com.diana.insurance.controller;

import com.diana.insurance.controller.request.BankRequest;
import com.diana.insurance.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/bank")
public class BankController {

    private final BankService service;

    @Autowired
    public BankController(BankService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("banks", service.getAll());

        return "bank/bank-main-page";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("bank", new BankRequest());

        return "bank/bank-create-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("bank") BankRequest request) {
        service.save(request);

        return "redirect:/bank/getAll";
    }

    @GetMapping("/showFormForAddLogo")
    public String showFormForAdd(@RequestParam long bankId, Model model) {
        model.addAttribute("bank_Id", bankId);

        return "bank/logo-create-form";
    }

    @PostMapping("/saveLogo")
    public String saveLogo(@RequestParam long bankId, @RequestParam MultipartFile logo) {
        service.saveLogo(logo, bankId);

        return "redirect:/bank/getAll";
    }


    @GetMapping("/deleteById")
    public String deleteById(@RequestParam("bankId") long id) {
        service.deleteById(id);

        return "redirect:/bank/getAll";
    }
}
