package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.TransactionDTO;
import lombok.Data;

@Data
public class TransactionRequest {

    private TransactionDTO transactionDTO;

    private long customerId;
}
