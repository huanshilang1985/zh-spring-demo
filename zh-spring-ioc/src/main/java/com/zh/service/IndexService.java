package com.zh.service;

import com.zh.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author zhanghe
 * Desc:
 * Date 2019/8/28 17:13
 */
@Service
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    private String aa;

    public IndexService(IndexDao indexDao){
        this.indexDao = indexDao;
    }

    public void service(){
        indexDao.test();
        System.out.println("aa ==" + aa);
    }

    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

}
