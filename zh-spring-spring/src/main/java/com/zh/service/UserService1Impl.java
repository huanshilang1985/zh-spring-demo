package com.zh.service;

import com.zh.dao.UserDao;

/**
 * service引用dao，也就是其他的bean
 * 方法1：new一个对象，但这个太耦合了。
 * 方法2：使用set方法
 * 方法3：使用构造方法
 *
 *
 * @author he.zhang
 * @date 2020/2/25 16:08
 */
public class UserService1Impl implements UserService {

    private UserDao dao;

    @Override
    public void find() {
        System.out.println("service1 find");
        dao.query();
    }

    /**
     * 使用set方法，来关联userDao
     * @param dao dao
     */
    public void setDao(UserDao dao){
        this.dao = dao;
    }
}
