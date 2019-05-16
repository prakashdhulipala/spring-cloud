package io.bank.service.Account.repository;

import io.bank.service.Account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    void deleteByUserId(String t);
}
