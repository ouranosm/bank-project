package com.ouranosm.bankproject.controller;

import com.ouranosm.bankproject.entity.Customer;
import com.ouranosm.bankproject.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public Customer create(@RequestBody Customer customer) {
    return customerService.create(customer);
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable("id") Long id) {
    return customerService.getCustomerById(id);
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    customerService.delete(id);
  }
}
