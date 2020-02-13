package com.zh.test;

import com.zh.dao.impl.UserDaoImpl;
import com.zh.proxy.UserLogTimeDaoImpl;

public class ProxyTest {

    /**
     * 假设UserDao和UserDaoImpl被封装到了jar包，不能修改源码。
     * UserDaoImpl是目标对象，UserLogDaoImpl是代理对象，实现了代理模式，通过代理模式实现了未侵入的日志打印。
     * 代理对象和目标对象是相对的。代理对象是增强后的对象，目标对象是被增强的对象。
     */
    public static void main(String[] args) {

        UserDaoImpl dao = new UserLogTimeDaoImpl();
        dao.query();
    }

}
