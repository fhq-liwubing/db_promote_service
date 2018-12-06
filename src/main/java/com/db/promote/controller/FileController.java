package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.File;
import com.db.promote.service.FileService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-06 18:38
 */
@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/listFile")
    public JSONObject listFile(HttpServletRequest request) {
        JSONObject jsonObject = CommonUtil.request2Json(request);
        PageInfo<File> filePageInfo = fileService
                .queryByExmaple(jsonObject.toJavaObject(File.class), jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(filePageInfo.getList(), filePageInfo.getPages(), filePageInfo.getTotal());
    }


}
