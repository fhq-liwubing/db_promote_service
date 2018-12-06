package com.db.promote.service;

import com.db.promote.entity.Task;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-03 20:23
 */
public interface TaskService {

    PageInfo<Task> getTaskList(Task task, Integer pageNum, Integer pageRow);
}
