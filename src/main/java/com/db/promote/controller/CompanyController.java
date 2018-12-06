package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Company;
import com.db.promote.service.CompanyService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-05 22:24
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/listCompany")
    public JSONObject listCompany(HttpServletRequest request) {
        JSONObject jsonObject = CommonUtil.request2Json(request);
        Company company = jsonObject.toJavaObject(Company.class);
        PageInfo<Company> pageInfo = companyService.queryByExample(company, jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(pageInfo.getList(), pageInfo.getPages(), pageInfo.getTotal());
    }


}
