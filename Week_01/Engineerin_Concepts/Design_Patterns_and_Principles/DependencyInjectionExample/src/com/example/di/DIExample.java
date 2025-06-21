package com.example.di;

public class DIExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl(); // Dependency
        CustomerService service = new CustomerService(repo);    // Injected

        service.displayCustomer("CUST001");
    }
}
