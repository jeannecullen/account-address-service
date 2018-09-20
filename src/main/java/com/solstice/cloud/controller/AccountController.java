package com.solstice.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import com.solstice.cloud.domain.Account;
import com.solstice.cloud.domain.Address;
import com.solstice.cloud.repo.AccountRepository;
import com.solstice.cloud.repo.AddressRepository;
import com.solstice.cloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/account")
public class AccountController {

    Logger logger  = LoggerFactory.getLogger("AccountController");


    AccountService accountService;

    public AccountController() {}

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    @HystrixCommand(fallbackMethod = "createAccountFallback")
    @ResponseBody
    public Account createAccount(@RequestBody Account account) {
        Account accountSaved = accountService.save(account);

        logger.info("Account saved: " + accountSaved.getAccountId());
        return account;
    }
    @GetMapping("/account/{accountId}")
    @HystrixCommand(fallbackMethod = "getAccountFallback")
    public Account getAccount(@PathVariable("accountId") Long accountId){
        Optional<Account> accountRetrieved = accountService.getAccount(accountId);
        Account account = accountRetrieved.get();
        return account;
    }

    @PutMapping("/account/{accountId}")
    @HystrixCommand(fallbackMethod = "updateAccountFallback")
    public Account updateAccount(@RequestBody Account account) {
        Account accountUpdated = accountService.save(account);
        logger.info("User updated: " + accountUpdated.getFirstName());
        return accountUpdated;
    }

    @DeleteMapping("/account/{accountId}")
    @HystrixCommand(fallbackMethod = "deleteAccountFallback")
    public ResponseEntity<?> deleteAccount(@PathVariable("accountId") long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok().body("Account has been deleted.");
    }

    public Account createAccountFallback(Account account) {
        logger.info("Error creating account " +account);
        return new Account();
    }

    public Optional<Account> getAccountFallback(Long accountId) {
        logger.info("Error getting account " +accountId);
        return Optional.of(new Account());
    }

    public Account updateAccountFallback(Account account) {
        logger.info("Error updating account " +account);
        return new Account();
    }

    public void deleteAccountFallback(Long accountId) {
        logger.info("Error deleting account " +accountId);
    }

}
