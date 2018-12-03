package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.service.CompanyOriginService;
import com.db.promote.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lib on 2018/12/3.
 */
@RestController
@RequestMapping("/companyOrigin")
public class CompanyOriginController {

    @Autowired
    private CompanyOriginService companyOriginService;

    /**
     * 查询客户资料列表
     *
     * @param request
     * @return
     */
    @RequiresPermissions("companyOrigin:list")
    @GetMapping("/listCompanyOrigin")
    public JSONObject listCompanyOrigin(HttpServletRequest request) {
        return companyOriginService.listCompanyOrigin(CommonUtil.request2Json(request));
    }
}
