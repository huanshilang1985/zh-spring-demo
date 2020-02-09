package com.zh.test;

import com.zh.entity.CityEntity;
import com.zh.util.CommUtil;

/**
 * 自定义注解测试
 */
public class Test {

    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = CommUtil.buildQuerySqlForeEntity(cityEntity);
        // select * from city where id="1" and name = "test";
        System.out.println("生成的SQL: " + sql);
    }
}
