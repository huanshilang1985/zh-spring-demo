package com.zh.test;

import com.zh.dao.AnnotationConfigApplicationContext;

/**
 * @author he.zhang
 * @date 2020/2/28 11:16
 */
public class Test2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.zh.service");
    }
}
