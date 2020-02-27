package com.zh.test;

import com.zh.service.UserService;
import org.spring.util.BeanFactory;

/**
 * @author he.zhang
 * @date 2020/2/25 16:10
 */
public class Test2 {

    /**
     * 使用spring.xml配置是手动装配
     * 读取配置文件spring2.xml，使用构造方法注入dao
     *
     */
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring2.xml");
        UserService service = (UserService) beanFactory.getBean("service");
        service.find();
    }

}
