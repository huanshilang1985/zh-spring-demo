package com.zh.test;

import com.zh.service.UserService;
import org.spring.util.BeanFactory2;

/**
 * @author he.zhang
 * @date 2020/2/25 16:10
 */
public class Test4 {

    /**
     * 读取配置文件spring4.xml，使用自动装配，文件里多个Dao，会根据service需要的类型注入
     *
     */
    public static void main(String[] args) {
        BeanFactory2 beanFactory = new BeanFactory2("spring4.xml");
        UserService service = (UserService) beanFactory.getBean("service");
        service.find();
    }

}
