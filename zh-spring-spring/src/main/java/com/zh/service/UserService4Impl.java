package com.zh.service;

import com.zh.dao.TestDao;

/**
 * service引用dao，也就是其他的bean
 * 方法1：new一个对象，但这个太耦合了。
 * 方法2：使用set方法
 * 方法3：使用构造方法
 *
 * 这个例子是使用spring4.xml，执行自动装配
 *
 * @author he.zhang
 * @date 2020/2/25 16:08
 */
public class UserService4Impl implements UserService {

    private TestDao dao;

    @Override
    public void find() {
        System.out.println("service4 find");
        dao.query();
    }

}
