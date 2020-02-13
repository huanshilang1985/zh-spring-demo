package com.zh.proxy;

import com.zh.dao.impl.UserDaoImpl;

/**
 * UserPowerDaoImpl继承了UserDaoImpl，使用继承实现了代理模式，实现了权限认证
 */
public class UserPowerDaoImpl extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("----- power ----");
        super.query();
    }
}
