package com.zh.test;

import com.zh.dao.UserDao;
import com.zh.dao.impl.UserDaoImpl;
import com.zh.proxy.UserLogDaoImpl;
import com.zh.proxy2.UserLogDao;
import com.zh.proxy2.UserTimeDao;

/**
 * 聚合方式，实现代理模式
 * 实现方式：目标对象和代理对象要实现同一个接口，代理对象当中要包含目标对象。
 */
public class Proxy2Test {

    /**
     * 聚合方式实现多重代理比较方式，根据嵌套顺序就可以确定代码执行顺序
     * 这里实现的其实是装饰者模式
     * 装饰者模式：目标对象是由构造对象传进来的。
     * 代理模式：目标对象是在程序里写死的。
     *
     * @param args
     */
    public static void main(String[] args) {
        UserDao target = new UserDaoImpl();
        // log + target
        UserDao proxy = new UserLogDao(target);
        // time + log + target
        UserDao proxy2 = new UserTimeDao(proxy);
        proxy2.query();

    }

}
