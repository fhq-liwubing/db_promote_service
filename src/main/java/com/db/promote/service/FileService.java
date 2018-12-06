package com.db.promote.service;

import com.db.promote.entity.File;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-06 18:35
 */
public interface FileService {

    PageInfo<File> queryByExmaple(File example, Integer pageNum, Integer pageRow);
}
