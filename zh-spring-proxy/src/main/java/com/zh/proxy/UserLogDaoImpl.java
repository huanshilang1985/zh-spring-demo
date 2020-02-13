package com.zh.proxy;

import com.zh.dao.impl.UserDaoImpl;

/**
 * UserLogDaoImpl继承了UserDaoImpl，使用继承实现代理模式，实现了日志打印
 */
public class UserLogDaoImpl extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("-------log---------");
        super.query();
    }
}
