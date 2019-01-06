package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.FileMapper;
import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import com.db.promote.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

}
