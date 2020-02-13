package com.zh.dao.impl;

import com.zh.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void query() {
        System.out.println("--query，假装查数据库--");
    }
}
