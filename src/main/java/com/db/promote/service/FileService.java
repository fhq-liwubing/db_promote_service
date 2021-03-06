package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import com.db.promote.param.FileUploadParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 17:39
 */
public interface FileService {

    PageInfo<File> pageSearch(PageRequest<FileQueryParam> pageRequest);

    List<File> queryAll(String terminalNo);

    void uploadFinish(FileUploadParam param, String fileNo, String filePath);

    String getFilePath(String fileNo);
}
