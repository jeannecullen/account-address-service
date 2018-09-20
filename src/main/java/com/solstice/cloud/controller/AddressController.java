package com.solstice.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.cloud.domain.Address;
import com.solstice.cloud.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    Logger logger = LoggerFactory.getLogger("AddressController");

   AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/account/{account}/address")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "createAddressFallback")
    public Address createAddress(@RequestBody Address address, @PathVariable Long account) {
        address.setAccount(account);
        if(address.getAccount() == null) {
            logger.info("Account is null");
        } else {
            logger.info("Account is not null");
        }
        Address addressSaved = addressService.save(address);
        logger.info("Address saved :" + addressSaved.toString());
        return address;
    }

    @GetMapping("/account/{account}/address")
    //@HystrixCommand(fallbackMethod = "getAddressForAccountFallback")
    public List<Address> getAddressForAccount(@PathVariable("account") Long account) {
        return addressService.getAddressForAccount(account);
    }

    @PutMapping("/account/{account}/address/{addressId}")
    @HystrixCommand(fallbackMethod = "updateAddressFallback")
    public Address updateAddress(@RequestBody Address address) {
        Address addressSaved = addressService.save(address);
        logger.info("Address updated: " + addressSaved.toString());
        return address;
    }

    @DeleteMapping("/account/{account}/address")
    @HystrixCommand(fallbackMethod = "deleteAddressFallback")
    public ResponseEntity<?> deleteAddress(@PathVariable("accountId") long accountId) {
        addressService.deleteAddress(accountId);
        return ResponseEntity.ok().body("Address has been deleted.");
    }

    public Address createAddressFallback(Address address, Long accountId) {
        logger.info("Error creating address " +address +accountId);
        return new Address();
    }

//    public Optional<Address> getAddressForAccountFallback(Long account) {
//        logger.info("Error getting address " +account);
//        return Optional.of(new Address());
//    }

    public Address updateAddressFallback(Address address) {
        logger.info("Error updating address " +address);
        return new Address();
    }

    public void deleteAddressFallback(Long addressId) {
        logger.info("Error deleting account " +addressId);
    }
}
