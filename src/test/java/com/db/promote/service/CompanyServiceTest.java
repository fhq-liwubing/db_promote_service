package com.db.promote.service;

import com.alibaba.fastjson.JSON;
import com.db.promote.entity.Company;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author kun
 * @version 2018-12-06 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void queryByExample() {
        Company company = new Company();
        company.setCompanyName("测试公司");
        PageInfo<Company> pageInfo = companyService.queryByExample(company, 1, 1);
        System.out.println(JSON.toJSONString(pageInfo));
    }

    @Test
    public void saveData() {
    }
}