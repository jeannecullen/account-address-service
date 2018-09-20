//package com.solstice.cloud.repo;
//
//import com.solstice.cloud.domain.Account;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//public class AccountRepositoryTest {
//
//    @Autowired
//    TestEntityManager entityManager;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//
//    @Test
//    public void testFindByAccountId() throws Exception{
//        this.entityManager.persist(new Account(6L,"Grace", "Cullen", "grace@mail.com"));
//        Account testAccount = this.accountRepository.findByAccountId(6L);
//        assertThat(testAccount.getAccountId()).isEqualTo(6L);
//        assertThat(testAccount.getFirstName()).isEqualTo("Grace");
//       }
//
//}