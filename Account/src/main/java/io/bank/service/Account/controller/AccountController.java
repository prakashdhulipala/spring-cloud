package io.bank.service.Account.controller;

import io.bank.service.Account.model.Account;
import io.bank.service.Account.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController implements BaseCtroller<Optional<Account>> {
    @Autowired
    private AccountServiceImpl accountService;

    @Override
    @GetMapping("/{id}")
    public Optional<Account> getById(@PathVariable("id") long id) {
        return accountService.getById(id);
    }

    @Override
    @GetMapping("/")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @Override
    @GetMapping("all/byIds")
    public List<Account> getByIds(@RequestParam("ids") List<Long> id) {
        return accountService.getByIds(id);
    }

    @Override
    @PostMapping("/")
    public void put(Optional<Account> account) {
        accountService.put(account);
    }

    @Override
    @DeleteMapping("/")
    public void deleteById(@PathVariable("id") long t) {
        accountService.deleteById(t);
    }

    @Override
    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable("id")  String t) {
        accountService.deleteById(t);
    }
}
