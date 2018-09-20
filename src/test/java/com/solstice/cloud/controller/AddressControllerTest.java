//package com.solstice.cloud.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.solstice.cloud.domain.Address;
//import com.solstice.cloud.service.AccountService;
//import com.solstice.cloud.service.AddressService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration
//public class AddressControllerTest {
//
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//    AddressService addressService;
//    Address address;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Configuration
//    @EnableAutoConfiguration
//    public static class Config {
//        @Bean
//        public AddressController addressController() {
//            return new AddressController();
//        }
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    public void testGetAddress() throws Exception {
//
//        Address mockAddress = new Address();
//        mockAddress.setAccount(1L);
//        mockAddress.setStreetName("Michigan Ave");
//        mockAddress.setUnit(777);
//        mockAddress.setCity("chicago");
//        mockAddress.setState("IL");
//        mockAddress.setZip(60611);
//
//        String requestJson = mapper.writeValueAsString(mockAddress);
//
//        mockMvc.perform(post("/account/{account}/address", address.getAccount())
//                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
//                .andExpect(status().isOk()).andReturn();
//        mockMvc.perform(get("/account/{account}/address", mockAddress.getAccount()))
//                .andExpect(status().isOk()).andReturn();
//
//        when(addressService.getAddressForAccount(1L)).thenReturn(mockAddress);
//
//    }
//}
