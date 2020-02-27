package com.zh.test;

import com.zh.service.UserService;
import org.spring.util.BeanFactory3;

/**
 * @author he.zhang
 * @date 2020/2/25 16:10
 */
public class Test5 {

    /**
     * 读取配置文件spring5.xml，手动装配自动装配混合使用，优先使用手动装配
     *
     */
    public static void main(String[] args) {
        BeanFactory3 beanFactory = new BeanFactory3("spring5.xml");
        UserService service = (UserService) beanFactory.getBean("service");
        service.find();
    }

}
