package com.zh.test;

import com.zh.conf.AppConfig;
import com.zh.dao.CardDao;
import com.zh.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author he.zhang
 * @date 2020/3/3 12:19
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CardDao dao = (CardDao) context.getBean("cardDao");
        UserDao dao2 = context.getBean(UserDao.class);
        dao.query();
        dao2.query();
    }

}
