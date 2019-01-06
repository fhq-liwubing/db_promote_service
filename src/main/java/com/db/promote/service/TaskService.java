package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.TaskPackage;
import com.db.promote.param.PackageAddParam;
import com.db.promote.param.PackageQueryParam;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2019-01-06 10:41
 */
public interface TaskService {

    PageInfo<TaskPackage> packagePageSearch(PageRequest<PackageQueryParam> pageRequest);

    void packageAdd(PackageAddParam param);
}
