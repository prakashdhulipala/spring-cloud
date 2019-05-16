package io.bank.service.Account.service;

import io.bank.service.Account.model.Account;
import io.bank.service.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements BaseIfc<Optional<Account>> {

    @Autowired
    private AccountRepository repository;

    @Override
    public Optional<Account> getById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Account> getByIds(List<Long> id) {
        return repository.findAllById(id);
    }

    @Override
    public void put(Optional<Account> account) {
        if(account.isPresent()) {
            Account save = repository.save(account.get());
        }
    }

    @Override
    public void deleteById(long t) {
        repository.deleteById(t);
    }

    @Override
    public void deleteById(String t) {
        repository.deleteByUserId(t);
    }
}
