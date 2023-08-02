package com.diana.insurance.service;

import com.diana.insurance.adviser.exception.ObjectAlreadyExistsException;
import com.diana.insurance.controller.request.CustomerRequest;
import com.diana.insurance.entity.Customer;
import com.diana.insurance.entity.Insurance;
import com.diana.insurance.repository.CustomerRepository;
import com.diana.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, InsuranceRepository insuranceRepository) {
        this.repository = repository;
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Customer getById(long id) {
        Customer customer = repository.findById(id).get();

        customer.setInsurances(null);

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = repository.findAll();

        customers.stream().forEach(customer -> {
            customer.setInsurances(null);
        });

        return customers;
    }

    @Override
    public void save(CustomerRequest request) {
        if (repository.existsBySinAndInsurances_Id(request.getCustomerDTO().getSin(), request.getInsuranceId())) {
            throw new ObjectAlreadyExistsException("Customer already has the Insurance");
        } else {
            Insurance insurance = insuranceRepository.findById(request.getInsuranceId()).get();
            Customer customer = new Customer(
                    request.getCustomerDTO().getSin(),
                    request.getCustomerDTO().isPaid(),
                    request.getCustomerDTO().getSigningDate()
            );
            customer.addInsurance(insurance);
            repository.save(customer);
            System.out.println(request.getCustomerDTO().isPaid() + "service");
        }
    }

    @Override
    public void deleteById(long id) {

        Customer customer = repository.findById(id).get();

        customer.setInsurances(null);

        repository.delete(customer);
    }


}
