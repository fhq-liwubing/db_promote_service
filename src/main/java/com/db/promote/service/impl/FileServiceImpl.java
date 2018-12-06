package com.db.promote.service.impl;

import com.db.promote.dao.FileMapper;
import com.db.promote.entity.File;
import com.db.promote.service.FileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kun
 * @version 2018-12-06 18:35
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public PageInfo<File> queryByExmaple(File example, Integer pageNum, Integer pageRow) {
        return PageHelper.startPage(pageNum, pageRow).doSelectPageInfo(() -> fileMapper.selectByExample(example));
    }

}
