package com.diana.insurance.controller;

import com.diana.insurance.controller.request.OwnerAndBankIdRequest;
import com.diana.insurance.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService service;

    @Autowired
    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @GetMapping("/getAllByBankId")
    public String getAllByBankId(@RequestParam long bankId, Model model) {
        model.addAttribute("owners", service.getOwnersByBankId(bankId));
        model.addAttribute("bank_Id", bankId);
        return "owner/owner-main-page";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam long bankId, Model model) {
        model.addAttribute("owner", new OwnerAndBankIdRequest());
        model.addAttribute("bank_Id", bankId);
        return "owner/owner-create-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam long bankId, @ModelAttribute OwnerAndBankIdRequest request) {
        request.setBankId(bankId);
        service.save(request);

        return "redirect:/owner/getAllByBankId?bankId=" + bankId;
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam long ownerId, @RequestParam long bankId) {

        service.deleteById(ownerId);

        return "redirect:/owner/getAllByBankId?bankId=" + bankId;
    }

}
