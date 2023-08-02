package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.OwnerDTO;
import lombok.Data;

@Data
public class OwnerAndBankAccountIdRequest {

    private OwnerDTO ownerDTO;

    private long bankAccId;
}
