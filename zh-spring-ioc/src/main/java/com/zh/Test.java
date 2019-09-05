package com.zh;

import com.zh.conf.SpringConfig;
import com.zh.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/28 17:11
 */
public class Test {

    public static void main(String[] args) {
        //读取配置文件方式
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // JavaConfig注解形式
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IndexService indexService = (IndexService) context.getBean("indexService");
        indexService.service();
    }

}
