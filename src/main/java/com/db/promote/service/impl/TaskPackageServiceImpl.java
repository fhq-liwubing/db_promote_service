package com.db.promote.service.impl;

import com.db.promote.dao.TaskPackageMapper;
import com.db.promote.entity.TaskPackage;
import com.db.promote.service.TaskPackageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kun
 * @version 2018-12-06 19:10
 */
@Service
public class TaskPackageServiceImpl implements TaskPackageService {

    @Autowired
    private TaskPackageMapper taskPackageMapper;

    @Override
    public PageInfo<TaskPackage> queryByExample(TaskPackage example, Integer pageNum, Integer pageRow) {
        return PageHelper.startPage(pageNum, pageRow).doSelectPageInfo(() -> taskPackageMapper.selectByExample(example));
    }

}
