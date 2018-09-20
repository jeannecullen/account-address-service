package com.solstice.cloud.repo;

import com.solstice.cloud.domain.Account;
import com.solstice.cloud.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository <Account, Long> {

    Account getAccountByAccountId(Long accountId);

}
