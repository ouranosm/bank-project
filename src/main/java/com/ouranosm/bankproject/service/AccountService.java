package com.ouranosm.bankproject.service;

import com.ouranosm.bankproject.entity.Account;
import com.ouranosm.bankproject.entity.Customer;
import com.ouranosm.bankproject.repository.AccountRepository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author : Xenofon Zinoviou
 */
@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final CustomerService customerService;

  public AccountService(AccountRepository accountRepository, CustomerService customerService) {
    this.accountRepository = accountRepository;
    this.customerService = customerService;
  }

  public Account create(Long id) {
    Customer customer = customerService.getCustomerById(id);

    Account account = new Account();
    account.setCustomer(customer);
    account.setDateCreated(OffsetDateTime.now());
    account.setBalance(BigDecimal.ZERO);

    customer.getAccounts().add(account);

    return accountRepository.save(account);
  }

  public Account getAccountById(Long id) {
    return accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Failed to retrieve account with id: " + id));
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  public void delete(Long id) {
    try {
      Account account = getAccountById(id);
      accountRepository.delete(account);
    } catch (RuntimeException e) {
      throw new RuntimeException("Failed to delete account with id: " + id);
    }
  }
}
