package io.bank.service.Account.service;


import io.bank.service.Account.model.Account;

import java.util.List;

public interface BaseIfc<T> {

    T getById(long id);
    List<Account> getAll();
    List<Account> getByIds(List<Long> id);

    void put(T t);

    void deleteById(long t);
    void deleteById(String t);

}
