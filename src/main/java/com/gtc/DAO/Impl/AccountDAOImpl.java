package com.gtc.DAO.Impl;

import com.gtc.DAO.AccountDAO;
import com.gtc.entity.Account;
import com.gtc.utils.DBUtils;
import com.gtc.utils.Orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private final Connection conn = DBUtils.getConnection();
    @Override
    public List<Account> selectALLAccount() throws SQLException {
        String sql = "select * from t_account;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            Orm.AccountOrm(account,resultSet);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Account selectAccountById(Integer id) throws SQLException {
        String sql = "select * from t_account where id=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        /*
        resultset的游标的起始位置是第一行前面，如果在这之前没有next（）一下，就会出现异常：
         */

        Account account = null;
        if (resultSet.next()) {
            account = new Account();
            Orm.AccountOrm(account,resultSet);
        }
        return account;
    }

    @Override
    public Account selectAccountByUsername(String name) throws SQLException {
        String sql = "select * from t_account where user_name=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        /*
        resultset的游标的起始位置是第一行前面，如果在这之前没有next（）一下，就会出现异常：
         */
        Account account = null;
        if (resultSet.next()) {
            account = new Account();
            Orm.AccountOrm(account,resultSet);
        }
        return account;
    }

    @Override
    public int updateAccountById(Account account) throws SQLException {
        String sql = "update t_account set user_name=?,user_password=?,name=?, sex=?, number=?, email=?, phone=?, type=?,card=?,balance=?,card_password=?,date=? where id=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,account.getUsername());
        statement.setString(2,account.getPassword());
        statement.setString(3,account.getName());
        statement.setString(4,account.getSex());
        statement.setString(5,account.getNumber());
        statement.setString(6,account.getEmail());
        statement.setString(7,account.getPhone());
        statement.setInt(8,account.getType());
        statement.setString(9,account.getCard());
        statement.setDouble(10,account.getBalance());
        statement.setString(11,account.getC_password());
        statement.setString(12,account.getDate());
        statement.setInt(13,account.getId());

        return statement.executeUpdate();
    }

    @Override
    public int insertAccount(Account account) throws SQLException {
        String sql = "insert into t_account (user_name, user_password, name, sex, number, email, phone, type, card, balance, card_password, date) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?);";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,account.getUsername());
        statement.setString(2,account.getPassword());
        statement.setString(3,account.getName());
        statement.setString(4,account.getSex());
        statement.setString(5,account.getNumber());
        statement.setString(6,account.getEmail());
        statement.setString(7,account.getPhone());
        statement.setInt(8,account.getType() == null ? 0:account.getType());
        statement.setString(9,account.getCard());
        statement.setDouble(10,account.getBalance() == null ? 0:account.getBalance());
        statement.setString(11,account.getC_password());
        statement.setString(12,account.getDate());
        return statement.executeUpdate();
    }

    @Override
    public int deleteAccountById(Integer id) throws SQLException {
        String sql = "delete from t_account where id=?;";
        assert conn != null;
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,id);
        return statement.executeUpdate();
    }
}
