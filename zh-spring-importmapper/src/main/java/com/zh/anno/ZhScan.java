package com.zh.anno;

import com.zh.test.MyImportBeanDefinitionRegistor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义的扫描器注解，模仿Mybatis的@MapperScan
 *
 * @author he.zhang
 * @date 2020/3/3 15:48
 */
@Import(MyImportBeanDefinitionRegistor.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ZhScan {



}
