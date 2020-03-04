package com.zh.test;


import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author he.zhang
 * @date 2020/3/3 15:11
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    Class clazz;

    /**
     * 这个带参数构造方法，Spring是不能直接new出来的
     * @param clazz
     */
    public MyFactoryBean(Class clazz){
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Class[] clazzArr = new Class[]{clazz};
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), clazzArr, this);
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("factoryBean proxy");
        // 下面这段代码是打印Mybatis的注解@Select里面的SQL
//        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), String.class);
//        Select select = method1.getDeclaredAnnotation(Select.class);
//        System.out.println(select.value()[0]);
        return null;
    }
}
