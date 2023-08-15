package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.InsuranceDTO;
import lombok.Data;

@Data
public class InsuranceRequest {

    private InsuranceDTO insuranceDTO;

    private long bankAccountId;
}
