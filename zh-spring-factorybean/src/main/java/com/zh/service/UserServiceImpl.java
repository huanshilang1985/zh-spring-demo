package com.zh.service;

import com.zh.anno.MyAnno;

/**
 * @author he.zhang
 * @date 2020/2/28 11:15
 */
@MyAnno("我是UserService注解")
public class UserServiceImpl implements UserService {

    @Override
    public String query() {
        System.out.println("UserServiceImpl Hello");
        return "Hello";
    }
}
