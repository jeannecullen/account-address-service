package com.solstice.cloud.service;

import com.solstice.cloud.domain.Address;
import com.solstice.cloud.repo.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger("AddressService");

    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super();
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        if(address.getAccount() == null) {
            logger.info("Account is null");
        } else {
            logger.info("Account is not null");
        }
        Address addressSaved = addressRepository.save(address);
        return addressSaved;
    }

    public List<Address> getAddressForAccount(Long account) {
        return addressRepository.getAddressByAccount(account);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
