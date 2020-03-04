package com.zh.imports;

import com.zh.dao.UserDao;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 自定义ImportSelector，实现类的动态加载，
 * 注意：UserDao并没有使用注解，需要使用@Import引用此类
 * 使用场景：可以实现一个功能的动态开启和关闭
 * @author he.zhang
 * @date 2020/3/3 19:27
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        // 可以通过下面注解拿到注解的值，或者类名，用于处理自己的用途
//        Set<String> enableZhScan = annotationMetadata.getMetaAnnotationTypes("EnableZhScan");


        return new String[]{UserDao.class.getName()};
    }
}
