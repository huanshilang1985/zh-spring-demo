package com.zh.service;

import com.zh.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author he.zhang
 * @date 2020/3/3 15:02
 */
@Service
public class CardService {

    @Autowired
    private CardDao cardDao;

    public void find(){
        System.out.println("service find ");
        cardDao.query();
    }

}
