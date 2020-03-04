package com.zh.dao;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Proxy;

/**
 * @author he.zhang
 * @date 2020/3/3 19:27
 */
public class UserDao {

    @Select("select * from user")
    public void query(){
        System.out.println("UserDao query");

        // 使用Import时，可以返回一个代理对象
//        return new Proxy.newProxyInstance()
    }
}
