package com.dmitriev.controller;

import com.dmitriev.entity.Customer;
import com.dmitriev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> showAllPositions() {
        List<Customer> allCustomer = customerService.getCustomers();
        return allCustomer;
    }
    @GetMapping("/customers/{id}")
    public Customer getPosition(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        return customer;
    }
    @PostMapping("/customers")
    public Customer addNewPosition(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }
    @PutMapping("/customers")
    public Customer updatePosition(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }
    @DeleteMapping("/customers/{id}")
    public String deletePosition(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "Customer with id = " + id + " was deleted";
    }

}
