package com.ouranosm.bankproject.controller;

import com.ouranosm.bankproject.entity.Account;
import com.ouranosm.bankproject.service.AccountService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/customers/{id}")
  public Account create(@PathVariable("id") Long id) {
    return accountService.create(id);
  }

  @GetMapping("/{id}")
  public Account getAccountById(@PathVariable("id") Long id) {
    return accountService.getAccountById(id);
  }

  @GetMapping
  public List<Account> getAllAccounts() {
    return accountService.getAllAccounts();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    accountService.delete(id);
  }
}
