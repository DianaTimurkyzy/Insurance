package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.CompanyDTO;
import lombok.Data;

@Data
public class CompanyAndBankAccountIdRequest {

    private CompanyDTO companyDTO;

    private long bankAccountId;
}
