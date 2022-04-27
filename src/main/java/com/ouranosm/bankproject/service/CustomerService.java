package com.ouranosm.bankproject.service;

import com.ouranosm.bankproject.entity.Customer;
import com.ouranosm.bankproject.repository.CustomerRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author : Xenofon Zinoviou
 */
@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer create(Customer customer) {
    customer.setDateCreated(OffsetDateTime.now());
    return customerRepository.save(customer);
  }

  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Failed to retrieve customer with id: " + id));
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public void delete(Long id) {
    try {
      Customer customer = getCustomerById(id);
      customerRepository.delete(customer);
    } catch (RuntimeException e) {
      throw new RuntimeException("Failed to delete customer with id: " + id);
    }
  }
}
