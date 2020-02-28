package com.zh.dao;

import com.zh.anno.MyAnno;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {

    @MyAnno
    @Override
    public void query1(String str){
        System.out.println("query1");
    }

    @Override
    public void query2(Integer i){
        System.out.println("query2");
    }

    @Override
    public void query3(String str, Integer i){
        System.out.println("query3");
    }

}
