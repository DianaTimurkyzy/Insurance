package com.diana.insurance.controller.request.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BankAccountDTO {

    @NotBlank
    @Size(min = 10, max = 20)
    private String accountNumber;

    @NotBlank
    private String name;

    @Min(value = 0, message = "Funds cannot be negative")
    private int funds;

    @PastOrPresent
    private LocalDate openingDate;

    @NotBlank
    private String country;

}
