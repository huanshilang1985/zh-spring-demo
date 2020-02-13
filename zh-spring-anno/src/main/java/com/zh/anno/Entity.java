package com.zh.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @Target() 元注解，表示此注解放的位置（可以同时使用多个）
 *  ElementType.TYPE  可以放在类上
 *  ElementType.FIELD 可以放在属性上
 *  ElementTYpe.METHOD 可以放在方法上
 *
 * @Retention()  元注解，声明此注解的声明周期
 * RetentionPolicy.SOURCE 默认值，表示注解只在源码里，编译成class文件后消失
 * RetentionPolicy.CLASS 表示只会存在编译后的class文件里，但在运行时会被java虚拟机忽略
 * RetentionPolicy.RUNTIME  运行时有效
 *
 *   如果注解方法只有一个，而且是value，表示可以省略，直接写内容
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    /**
     * name 方法是必须要填写值的
     * @return
     */
//    String name();

    /**
     * 注解方法
     * default是默认值，表示在使用此注解时可以不写
     *
     * @return
     */
    String value() default "";

}
