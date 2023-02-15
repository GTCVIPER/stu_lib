package com.gtc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String number;
    private String email;
    private String phone;
    private Integer type;
    private String card;
    private Double balance;
    private String c_password;
    private String date;

}
