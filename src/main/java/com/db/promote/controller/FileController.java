package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import com.db.promote.service.FileService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.FileVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2019-01-06 17:33
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FileService fileService;

    @GetMapping("/list")
    public JSONObject list() {
        PageInfo<File> pageInfo = fileService.pageSearch(CommonUtil.requestToPageReq(request, FileQueryParam.class));
        return CommonUtil.successPage(pageInfo, this::buildVO);
    }

    @GetMapping("/my/{terminalNo}/list")
    public JSONObject myList(@PathVariable String terminalNo) {
        return CommonUtil.successList(fileService.queryAll(terminalNo));
    }

    public JSONObject upload() {
        return null;
    }

    public JSONObject downLoad(String fileNo) {
        return null;
    }

    private FileVO buildVO(File file) {
        FileVO vo = new FileVO();
        vo.setFileNo(file.getFileNo());
        vo.setFileType(file.getFileType());
        vo.setFileName(file.getFileName());
        vo.setFilePath(file.getFilePath());
        vo.setBelongTerminal(file.getBelongTerminal());
        vo.setShare(file.getShare());
        vo.setUpdateTime(DateUtil.format(file.getUpdateTime()));
        vo.setState(file.getState());
        vo.setRemark(file.getRemark());
        vo.setCreateTime(DateUtil.format(file.getCreateTime()));
        return vo;
    }

}
