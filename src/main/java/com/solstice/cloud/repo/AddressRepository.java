package com.solstice.cloud.repo;

import com.solstice.cloud.domain.Account;
import com.solstice.cloud.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> getAddressByAccount(Long account);


}
