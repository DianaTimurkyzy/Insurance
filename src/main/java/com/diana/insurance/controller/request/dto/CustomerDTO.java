package com.diana.insurance.controller.request.dto;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {

    private int sin;

    private boolean isPaid;

    @PastOrPresent
    private LocalDate signingDate;

}
