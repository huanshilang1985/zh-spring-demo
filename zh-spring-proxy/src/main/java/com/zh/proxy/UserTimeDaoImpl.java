package com.zh.proxy;

import com.zh.dao.impl.UserDaoImpl;

/**
 * UserTimeDaoImpl实现了UserDaoImpl，通过继承实现了代理模式，实现执行时间打印功能
 */
public class UserTimeDaoImpl extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("----- time ----");
        super.query();
    }
}
