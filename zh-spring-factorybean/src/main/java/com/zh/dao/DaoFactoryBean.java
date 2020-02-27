package com.zh.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean首先是一个Bean，受Spring管理的一个对象。
 * 继承FactoryBean接口，需要实现下面3个方法
 *
 * 如果你的类实现了FactoryBean，那么Spring容器当中存在两个对象，一个是getObject()的返回对象，一个是当前对象
 * getObject得到的对象是当前类指定的名字，当前名称是'&'+当前指定名称
 *
 * 如果一个对象非常复杂，但还需要提供给其他人使用，就可以使用FactoryBean，经典使用的是MyBatis的SqlSessionFactoryBean
 *
 * @author he.zhang
 * @date 2020/2/25 15:51
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    /**
     * 测试方法
     */
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
