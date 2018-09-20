//package com.solstice.cloud.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.solstice.cloud.domain.Account;
//import com.solstice.cloud.service.AccountService;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static sun.nio.cs.Surrogate.is;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration
//public class AccountControllerTest {
//
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//    AccountService accountService;
//    Account account;
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Configuration
//    @EnableAutoConfiguration
//    public static class Config {
//        @Bean
//        public AccountController accountController() {
//            return new AccountController();
//        }
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    public void testGetAccount() throws Exception {
//
//        Account mockAccount = new Account();
//        mockAccount.setFirstName("a");
//        mockAccount.setLastName("b");
//        mockAccount.setEmailAddress("c@mail.com");
//        accountService.save(mockAccount);
//        String requestJson = mapper.writeValueAsString(mockAccount);
//
//        when(accountService.getAccount(1L)).thenReturn(mockAccount);
//
//        mockMvc.perform(post("account/{accountId}", account.getAccountId())
//                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
//                .andExpect(status().isOk()).andReturn();
//
//        mockMvc.perform(get("/account/{accountId}", mockAccount.getAccountId()))
//                .andExpect(status().isOk()).andReturn();
//
//
//
//    }
//}