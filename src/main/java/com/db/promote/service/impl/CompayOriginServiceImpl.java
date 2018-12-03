package com.db.promote.service.impl;

import com.db.promote.component.GanjiClient;
import com.db.promote.dao.CompanyOriginDao;
import com.db.promote.entity.CompanyOrigin;
import com.db.promote.service.CompanyOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lib on 2018/12/3.
 */
@Service
public class CompayOriginServiceImpl implements CompanyOriginService {

    private static final Logger log = LoggerFactory.getLogger(CompayOriginServiceImpl.class);

    @Autowired
    private CompanyOriginDao companyOriginDao;

    @Override
    public void insert(CompanyOrigin input) {
        try{
            input.setCreateTime(new Date());
            input.setUpdateTime(new Date());
            companyOriginDao.insert(input);
        }catch (Exception e){
            log.info("保存数据库异常：{}",e.getMessage());
        }


    }
}
