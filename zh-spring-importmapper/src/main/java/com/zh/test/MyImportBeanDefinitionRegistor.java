package com.zh.test;

import com.zh.dao.CardDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义的ImportBeanDefinitionRegistrar类，用于往Spring容器内加载bd
 *
 * @author he.zhang
 * @date 2020/3/3 12:16
 */
public class MyImportBeanDefinitionRegistor implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {



        // 使用动态代理，实现CardDao
        // 扫描所有的包，（这是只是手动这死的了）
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CardDao.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        System.out.println(beanDefinition.getBeanClassName());
        // 添加构造方法
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.zh.dao.CardDao");
        beanDefinition.setBeanClass(MyFactoryBean.class);

        registry.registerBeanDefinition("cardDao", beanDefinition);



    }

























}
