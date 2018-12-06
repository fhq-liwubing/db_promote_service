package com.db.promote.service;

import com.db.promote.entity.TaskPackage;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-06 19:10
 */
public interface TaskPackageService {

    PageInfo<TaskPackage> queryByExample(TaskPackage example, Integer pageNum, Integer pageRow);
}
