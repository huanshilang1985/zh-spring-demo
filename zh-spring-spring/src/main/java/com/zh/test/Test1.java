package com.zh.test;

import com.zh.service.UserService;
import org.spring.util.BeanFactory;

/**
 * @author he.zhang
 * @date 2020/2/25 16:10
 */
public class Test1 {

    /**
     * 使用spring.xml配置是手动装配
     * 读取spring.xml，使用set方法注入Dao
     *
     */
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService service = (UserService) beanFactory.getBean("service");
        service.find();
    }

}
