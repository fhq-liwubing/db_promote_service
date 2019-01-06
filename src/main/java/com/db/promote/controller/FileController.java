package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import com.db.promote.param.FileUploadParam;
import com.db.promote.service.FileService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.util.constants.Constants;
import com.db.promote.util.constants.ErrorEnum;
import com.db.promote.vo.FileVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author kun
 * @version 2019-01-06 17:33
 */
@RestController
@RequestMapping("/file")
public class FileController implements InitializingBean {

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

    /**
     * 不指定特定终端时 terminalNo = 0
     */
    @PostMapping("/upload")
    public JSONObject upload(MultipartFile file, FileUploadParam param) throws IOException {

        if (file == null) {
            throw new CommonJsonException(ErrorEnum.E_90003, "未指定文件");
        }

        String fileNo = UUID.randomUUID().toString().replace("-", "");
        String filePath = Constants.FILE_DIR + fileNo;
        java.io.File destFile = new java.io.File(filePath);

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            writer.flush();
        }
        fileService.uploadFinish(param, fileNo, filePath);
        return CommonUtil.successJson();
    }

    @GetMapping("/download/{fileNo}")
    public JSONObject downLoad(@PathVariable String fileNo, HttpServletResponse response) {
        String filePath = fileService.getFilePath(fileNo);

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

    @Override
    public void afterPropertiesSet() throws Exception {
        java.io.File dir = new java.io.File(Constants.FILE_DIR);
        if (!dir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            dir.mkdirs();
        }
    }
}
