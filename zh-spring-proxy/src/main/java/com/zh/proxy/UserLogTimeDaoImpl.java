package com.zh.proxy;

/**
 * UserLogTimeDaoImpl实现了UserLogDaoImpl，通过链式继承的方式，实现了多重功能
 *
 * 因为业务需求的先后顺序不同，就会有很多组合，所以用继承来实现代理模式，就有很多类。
 */
public class UserLogTimeDaoImpl extends UserLogDaoImpl {

    @Override
    public void query() {
        System.out.println("----- log and time ----");
        super.query();
    }
}
