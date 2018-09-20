//package com.solstice.cloud.repo;
//
//import com.solstice.cloud.domain.Address;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class AddressRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Test
//    public void test() {
//        this.entityManager.persist(new Address(1L, "Street Place", 100 , "Chicago", "IL", 07040,"USA",6L ));
//        Address address = this.addressRepository.getAddressByAccount(6L);
//        assertThat(address.getAccount()).isEqualTo(6L);
//
//    }
//
//
//}