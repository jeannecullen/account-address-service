package com.solstice.cloud.service;

import com.solstice.cloud.domain.Account;
import com.solstice.cloud.domain.Address;
import com.solstice.cloud.repo.AccountRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        Account accountSaved = accountRepository.save(account);
        return accountSaved;
    }

    public Optional<Account> getAccount(Long accountId) {
       return accountRepository.findById(accountId);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

}
