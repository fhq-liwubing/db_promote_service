package com.db.promote.service;

import com.db.promote.entity.Company;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-05 22:03
 */
public interface CompanyService {

    PageInfo<Company> queryByExample(Company company, Integer pageNum, Integer pageRow);

    void saveData(Company company);

    Company findOne(String companyNo);

}
