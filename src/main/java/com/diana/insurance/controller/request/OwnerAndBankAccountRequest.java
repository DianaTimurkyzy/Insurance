package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.BankAccountDTO;
import com.diana.insurance.controller.request.dto.OwnerDTO;
import lombok.Data;

@Data
public class OwnerAndBankAccountRequest {

    private BankAccountDTO bankAccountDTO;

    private OwnerDTO ownerDTO;

}
