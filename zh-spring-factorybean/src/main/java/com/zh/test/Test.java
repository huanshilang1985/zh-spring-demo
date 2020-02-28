package com.zh.test;

import com.zh.conf.AppConfig;
import com.zh.dao.TempDaoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author he.zhang
 * @date 2020/2/27 15:00
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TempDaoFactoryBean temp = (TempDaoFactoryBean) context.getBean("daoFactoryBean");
        temp.test();
    }
}
