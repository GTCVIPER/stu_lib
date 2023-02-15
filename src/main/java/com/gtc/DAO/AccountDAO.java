package com.gtc.DAO;

import com.gtc.entity.Account;


import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    List<Account> selectALLAccount() throws SQLException;

    Account selectAccountById(Integer id) throws SQLException;

    Account selectAccountByUsername(String name) throws SQLException;

    int updateAccountById(Account account) throws SQLException;

    int insertAccount(Account account) throws SQLException;

    int deleteAccountById(Integer id) throws SQLException;

}
