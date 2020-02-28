package com.zh.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解，代替Spring环境的@Service等注解
 *
 * @author he.zhang
 * @date 2020/2/28 11:05
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    public String value();

}
