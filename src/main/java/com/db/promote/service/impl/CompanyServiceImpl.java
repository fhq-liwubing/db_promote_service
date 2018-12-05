package com.db.promote.service.impl;

import com.db.promote.dao.CompanyMapper;
import com.db.promote.entity.Company;
import com.db.promote.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lib on 2018/11/20.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public PageInfo<Company> queryByExample(Company company, Integer pageNum, Integer pageRow) {
        return PageHelper.startPage(pageNum, pageRow).doSelectPageInfo(() ->
                companyMapper.selectByExample(company)
        );
    }

    @Override
    public void saveData(Company company){
        try{
            company.setCreateTime(new Date());
            companyMapper.insert(company);
            log.info("保存数据库成功...");
        }catch (Exception ex){
            log.info("保存数据库出现异常：{}",ex.getMessage());
        }
    }
}
