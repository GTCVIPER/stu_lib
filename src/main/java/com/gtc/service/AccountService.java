package com.gtc.service;

import com.gtc.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findALLAccount();

    Account findAccountById(Integer id);

    Account findAccountByUsername(String name);

    void modifyAccount(Account account);

    boolean saveAccount(Account account);

    void delAccountById(Integer id);

    boolean transBalanceBetweenAccounts(Integer sendId,Integer acceptId,Double money);

}
