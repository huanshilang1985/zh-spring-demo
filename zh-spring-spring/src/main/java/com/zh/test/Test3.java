package com.zh.test;

import com.zh.service.UserService;
import org.spring.util.BeanFactory2;

/**
 * @author he.zhang
 * @date 2020/2/25 16:10
 */
public class Test3 {

    /**
     * 读取配置文件spring3.xml，使用自动装配
     *
     */
    public static void main(String[] args) {
        BeanFactory2 beanFactory = new BeanFactory2("spring3.xml");
        UserService service = (UserService) beanFactory.getBean("service");
        service.find();
    }

}
