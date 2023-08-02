package com.diana.insurance.controller.request;

import com.diana.insurance.controller.request.dto.CustomerDTO;
import lombok.Data;

@Data
public class CustomerRequest {

    private CustomerDTO customerDTO;

    private long insuranceId;
}
