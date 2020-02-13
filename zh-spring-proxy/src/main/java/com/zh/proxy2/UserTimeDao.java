package com.zh.proxy2;

import com.zh.dao.UserDao;

/**
 * 通过聚合方式，UserDao是目标对象，UserLogDao是代理对象
 */
public class UserTimeDao implements UserDao {

    private UserDao dao;

    public UserTimeDao(UserDao dao){
        this.dao = dao;
    }

    @Override
    public void query() {
        System.out.println("---time---");
        dao.query();
    }
}
