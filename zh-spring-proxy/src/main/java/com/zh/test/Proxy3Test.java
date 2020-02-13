package com.zh.test;

import com.zh.dao.UserDao;
import com.zh.proxy3.ProxyUtil;

public class Proxy3Test {

    public static void main(String[] args) {
        UserDao proxy = (UserDao) ProxyUtil.newInstance(UserDao.class);
    }

}
