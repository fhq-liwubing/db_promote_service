package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.FileMapper;
import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import com.db.promote.param.FileUploadParam;
import com.db.promote.service.FileService;
import com.db.promote.util.constants.ErrorEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 17:39
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public PageInfo<File> pageSearch(PageRequest<FileQueryParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> fileMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public List<File> queryAll(String terminalNo) {
        return fileMapper.selectAll(terminalNo);
    }

    @Override
    public void uploadFinish(FileUploadParam param, String fileNo, String filePath) {
        File file = new File();
        file.setFileNo(fileNo);
        file.setFileType(0);
        file.setFileName(param.getFileName());
        file.setFilePath(filePath);
        file.setBelongTerminal(StringUtils.isBlank(param.getTerminalNo()) ? "0" : param.getTerminalNo());
        file.setShare(param.getShare());
        file.setState(1);
        file.setRemark(param.getRemark());
        fileMapper.insertSelective(file);
    }

    @Override
    public String getFilePath(String fileNo) {
        File file = fileMapper.selectByFileNo(fileNo);
        if (file == null) {
            throw new CommonJsonException(ErrorEnum.E_4000, "文件不存在");
        }
        return file.getFilePath();
    }

}
