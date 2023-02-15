package com.gtc.controller;

import com.gtc.entity.Account;
import com.gtc.service.AccountService;
import com.gtc.service.Impl.AccountServiceImpl;

public class AccountController {

    public boolean login(String username,String password) {
        AccountService accountService = new AccountServiceImpl();
        Account account = accountService.findAccountByUsername(username);
//        System.out.println(account);
        if (account == null) {
            return false;
        } else {
            return account.getPassword().equals(password);
        }
    }

    public boolean register(Account account) {
        AccountService accountService = new AccountServiceImpl();
        return accountService.saveAccount(account);
    }

    public boolean transBalance(Integer sendId, Integer acceptId, Double money) {
        AccountService accountService = new AccountServiceImpl();
        return accountService.transBalanceBetweenAccounts(sendId, acceptId, money);
    }
}
