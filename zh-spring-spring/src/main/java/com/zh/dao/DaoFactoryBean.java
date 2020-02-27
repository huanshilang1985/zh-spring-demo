package com.zh.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean首先是一个Bean，受Spring管理的一个对象。
 * 继承FactoryBean接口，需要实现下面3个方法
 *
 * @author he.zhang
 * @date 2020/2/25 15:51
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    public void testBean(){
        System.out.println("testBean");
    }

    /**
     * 返回对象实例
     * @return Object
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }

    /**
     * 返回对象类型
     * @return Class<?>
     */
    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    /**
     * 是否是单例方法，默认是false
     * @return boolean
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
