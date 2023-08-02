package com.diana.insurance.service;

import com.diana.insurance.controller.request.CustomerRequest;
import com.diana.insurance.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(long id);

    List<Customer> getAll();

    void save(CustomerRequest request);

    void deleteById(long id);
}
