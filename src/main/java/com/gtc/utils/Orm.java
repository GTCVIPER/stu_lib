package com.gtc.utils;

import com.gtc.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orm {

    public static void AccountOrm(Account account,ResultSet resultSet) throws SQLException {
        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString("user_name"));
        account.setPassword(resultSet.getString("user_password"));
        account.setName(resultSet.getString("name"));
        account.setSex(resultSet.getString("sex"));
        account.setNumber(resultSet.getString("number"));
        account.setEmail(resultSet.getString("email"));
        account.setPhone(resultSet.getString("phone"));
        account.setType(resultSet.getInt("type"));
        account.setCard(resultSet.getString("card"));
        account.setBalance(resultSet.getDouble("balance"));
        account.setC_password(resultSet.getString("card_password"));
        account.setDate(resultSet.getString("date"));
    }
}
