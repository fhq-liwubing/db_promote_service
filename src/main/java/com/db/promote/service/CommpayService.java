package com.db.promote.service;

import com.db.promote.dao.CommpayDao;
import com.db.promote.entity.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lib on 2018/11/20.
 */
@Service
public class CommpayService {

    private static final Logger log = LoggerFactory.getLogger(CommpayService.class);

    @Autowired
    private CommpayDao commpayDao;

    public void insert(Company company){
        try{
            company.setCreateTime(new Date());
            commpayDao.insert(company);
            log.info("保存数据库成功...");
        }catch (Exception ex){
            log.info("保存数据库出现异常：{}",ex.getMessage());
        }
    }
}
