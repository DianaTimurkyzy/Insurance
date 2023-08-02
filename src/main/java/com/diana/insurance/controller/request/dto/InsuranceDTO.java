package com.diana.insurance.controller.request.dto;

import com.diana.insurance.enums.InsuranceType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class InsuranceDTO {

    private InsuranceType insuranceType;

    private int pricePerMonth;

    @Min(value = 0, message = "Coverage percentage cannot be negative")
    @Max(value = 100, message = "Coverage percentage cannot exceed 100")
    private int coveragePercentage;

}
