package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.TaskPackage;
import com.db.promote.service.TaskPackageService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 * @version 2018-12-06 19:12
 */
@RequestMapping("/package")
@RestController
public class TaskPackageController {

    @Autowired
    private TaskPackageService packageService;

    @GetMapping("/listPackage")
    public JSONObject listPackage(HttpServletRequest request) {
        JSONObject jsonObject = CommonUtil.request2Json(request);
        PageInfo<TaskPackage> pageInfo = packageService
                .queryByExample(jsonObject.toJavaObject(TaskPackage.class), jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(pageInfo);
    }

}
