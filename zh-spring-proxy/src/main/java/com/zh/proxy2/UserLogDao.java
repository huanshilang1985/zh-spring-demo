package com.zh.proxy2;

import com.zh.dao.UserDao;

/**
 * 通过聚合方式，UserDao是目标对象，UserLogDao是代理对象
 */
public class UserLogDao implements UserDao {

    private UserDao dao;

    public UserLogDao(UserDao dao){
        this.dao = dao;
    }

    @Override
    public void query() {
        System.out.println("---log---");
        dao.query();
    }
}
