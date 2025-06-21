package com.example.di;

public class CustomerService {
    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(String customerId) {
        String customer = repository.findCustomerById(customerId);
        System.out.println("Found: " + customer);
    }
}
