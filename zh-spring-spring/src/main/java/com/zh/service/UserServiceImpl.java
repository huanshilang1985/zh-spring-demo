package com.zh.service;

import com.zh.dao.UserDao;

public class UserServiceImpl implements UserService {

    UserDao dao;

    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }

}
