package com.zh.test;

import com.zh.app.AppConfig;
import com.zh.dao.IndexDao;
import com.zh.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AopTest {

    public static void main(String[] args) {
        /**
         * JDK的动态代理，是基于接口的，因为，所以一定要用继承方式实现。
         * 下面方法用context.getBean()如果填写的是实现类，就会报错。只能填接口
         * 因为所有对象都继承了proxy, proxy(代理对象)并不等于target(目标对象)，但他们的接口是相等的
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao bean = context.getBean(IndexDao.class);
        bean.query1("str");
        bean.query2(1);
        bean.query3("str", 1);

    }

    /**
     * 动态代理测试方法
     */
    public static void a(){
        Class<?>[] interfaces = new Class[]{IndexDao.class};
        byte[] bytes = ProxyGenerator.generateProxyClass("LuBanAa", interfaces);
        File file = new File("d:\\Test.class");

        try {
            FileOutputStream fw = new FileOutputStream(file);
            fw.write(bytes);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
