package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.BankAccountDTO;
import com.diana.insurance.controller.request.dto.CompanyDTO;
import lombok.Data;

@Data
public class CompanyAndBankAccountRequest {

    private BankAccountDTO bankAccountDTO;

    private CompanyDTO companyDTO;

}
