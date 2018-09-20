package com.solstice.cloud;

import com.solstice.cloud.domain.Address;
import com.solstice.cloud.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AddressServiceTest {

    @Autowired private AddressService addressService;

    @Test
    public void testAddAddress() {
        Address newAddress = new Address();
        newAddress.setStreetName("111 N Canal Street");
        newAddress.setUnit(700);
        newAddress.setCity("Chicago");
        newAddress.setZip(60611);
        newAddress.setCountry("USA");

        Address test = addressService.save(newAddress);

        assertNotNull(test);
        assertNotNull(test.getAddressId());
        assertEquals("111 N Canal Street", test.getStreetName());
    }
}
