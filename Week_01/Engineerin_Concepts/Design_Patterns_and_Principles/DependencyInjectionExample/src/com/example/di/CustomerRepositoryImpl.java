package com.example.di;

public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String customerId) {
        return "Customer[ID=" + customerId + ", Name=Saurabh Mehta]";
    }
}
