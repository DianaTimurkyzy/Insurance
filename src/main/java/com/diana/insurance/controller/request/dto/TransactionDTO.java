package com.diana.insurance.controller.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {

    @NotBlank
    private String month;

    @PastOrPresent
    private LocalDate paidAt;

    private int amountPaid;
}
