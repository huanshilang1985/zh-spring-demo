package com.zh.util;

import com.zh.anno.Entity;

public class CommUtil {

    /**
     * 通过一个对象构建一个查询的SQL
     *
     * @param object
     */
    public static String buildQuerySqlForeEntity(Object object) {
        String entityName = "";
        Class clazz = object.getClass();
        // 1. 判断是否加了这个注解, clazz.isAnnotationPresent(Entity.class)
        if (clazz.isAnnotationPresent(Entity.class)) {
            // 2. 得到注解，返回对象是Annotation，因为自定义注解都是继承自Annotation，所以可以强转。
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
            // 3. 调用方法
            entityName = entity.value();
            System.out.println(entityName);
        }
        String sql = "select * from " + entityName;
        return sql;
    }

}
