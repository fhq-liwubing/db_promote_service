package com.db.promote.service.impl;

import com.db.promote.dao.TaskMapper;
import com.db.promote.entity.Task;
import com.db.promote.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-03 20:24
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public PageInfo<Task> getTaskList(Task task, Integer pageNum, Integer pageRow) {
        return PageHelper.startPage(pageNum, pageRow).doSelectPageInfo(() -> taskMapper.selectByExample(task));
    }

    @Override
    public void updateTask(Task task) {
        taskMapper.updateByPrimaryKeySelective(task);
    }

}
