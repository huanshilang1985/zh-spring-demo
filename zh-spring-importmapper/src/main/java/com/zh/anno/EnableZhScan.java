package com.zh.anno;

import com.zh.imports.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解，用于开启扫描事务
 * @author he.zhang
 * @date 2020/3/3 19:32
 */
@Import(MyImportSelector.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableZhScan {
}
