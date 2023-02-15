package com.gtc.service.Impl;

import com.gtc.DAO.AccountDAO;
import com.gtc.DAO.Impl.AccountDAOImpl;
import com.gtc.entity.Account;
import com.gtc.service.AccountService;
import com.gtc.utils.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO = new AccountDAOImpl();
    @Override
    public List<Account> findALLAccount() {
        try {
            DBUtils.Begin();
            List<Account> accounts = accountDAO.selectALLAccount();
            DBUtils.Commit();
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            DBUtils.Begin();
            Account account = accountDAO.selectAccountById(id);
            DBUtils.Commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
        return null;
    }

    @Override
    public Account findAccountByUsername(String name) {
        try {
            DBUtils.Begin();
            Account account = accountDAO.selectAccountByUsername(name);
            DBUtils.Commit();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
        return null;
    }

    @Override
    public void modifyAccount(Account account) {
        try {
            DBUtils.Begin();
            System.out.println(accountDAO.updateAccountById(account));
            DBUtils.Commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
    }

    @Override
    public boolean saveAccount(Account account) {
        try {
            DBUtils.Begin();
            System.out.println(accountDAO.insertAccount(account));
            DBUtils.Commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
            return false;
        }
    }

    @Override
    public void delAccountById(Integer id) {
        try {
            DBUtils.Begin();
            System.out.println(accountDAO.deleteAccountById(id));
            DBUtils.Commit();
        } catch (Exception e) {
            e.printStackTrace();
            DBUtils.Rollback();
        }
    }

    @Override
    public boolean transBalanceBetweenAccounts(Integer sendId, Integer acceptId, Double money) {
         Account account1 = null;
         Account account2 = null;
        try {
            account1 = accountDAO.selectAccountById(sendId);
//            int f = 23 / 0;
            account2 = accountDAO.selectAccountById(acceptId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(account1);
        System.out.println(account2);

        if (account1 != null && account2 != null) {
            if (account1.getBalance() < money) {
                return false;
            } else {
                account1.setBalance(account1.getBalance() - money);
                account2.setBalance(account2.getBalance() + money);
                System.out.println(account1);
                System.out.println(account2);


                try {
                    DBUtils.Begin();
                    accountDAO.updateAccountById(account1);
//                    int c = 34 / 0;
                    accountDAO.updateAccountById(account2);
                    DBUtils.Commit();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    DBUtils.Rollback();
                }

                return true;
            }
//
        }
        return false;
    }
}
