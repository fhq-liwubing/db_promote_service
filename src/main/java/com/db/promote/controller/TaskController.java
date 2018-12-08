package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Task;
import com.db.promote.service.TaskService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-03 19:41
 */
@RestController
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/task/list")
    public JSONObject getTaskList(HttpServletRequest request) {
        JSONObject jsonObject = CommonUtil.request2Json(request);
        PageInfo<Task> pageInfo = taskService
                .getTaskList(jsonObject.toJavaObject(Task.class), jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(pageInfo.getList(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @PutMapping("/one/{taskNo}")
    public JSONObject updateTask(@PathVariable("taskNo") Task task) {
        taskService.updateTask(task);
        return CommonUtil.successJson();
    }


}
