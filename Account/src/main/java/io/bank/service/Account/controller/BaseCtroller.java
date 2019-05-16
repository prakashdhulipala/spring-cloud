package io.bank.service.Account.controller;


import io.bank.service.Account.model.Account;

import java.util.List;

public interface BaseCtroller<T> {
    /**
     * Interface to implement Basic Get Operations for the API
     * @param id
     * @return
     */
    T getById(long id);
    List<Account> getAll();
    List<Account> getByIds(List<Long> id);

    /**
     * Interface to implement Basic PUT Operations for the API
     * @param t
     */
    void put(T t);

    /**
     * Interface to implement Basic delete Operations for the API
     * @param t
     */
    void deleteById(long t);
    void deleteById(String t);

}
