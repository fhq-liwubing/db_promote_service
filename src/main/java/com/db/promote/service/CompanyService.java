package com.db.promote.service;

import com.db.promote.dao.CompanyDao;
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
public class CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    private CompanyDao companyDao;

    public void insert(Company company){
        try{
            company.setCreateTime(new Date());
            companyDao.insert(company);
            log.info("保存数据库成功...");
        }catch (Exception ex){
            log.info("保存数据库出现异常：{}",ex.getMessage());
        }
    }
}
