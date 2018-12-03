package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void getTaskList(@RequestBody JSONObject jsonObject) {

    }


}
