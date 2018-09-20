package com.solstice.cloud;

import com.solstice.cloud.domain.Account;
import com.solstice.cloud.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void testAddAccount() {
        Account newAccount = new Account();
        newAccount.setFirstName("Jane");
        newAccount.setLastName("Doe");
        newAccount.setEmailAddress("jd@gmail.com");

        Account test = accountService.save(newAccount);

        assertNotNull(test);
        assertNotNull(test.getAccountId());
        assertEquals("Jane", test.getFirstName());
    }
}
