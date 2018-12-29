package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Phone;
import com.db.promote.param.PhoneQueryParam;
import com.db.promote.service.PhoneService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-29 17:55
 */
@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        PageInfo<Phone> pageInfo = phoneService
                .pageSearch(CommonUtil.requestToPageReq(request, PhoneQueryParam.class));
        return CommonUtil.successPage(pageInfo);
    }




}
