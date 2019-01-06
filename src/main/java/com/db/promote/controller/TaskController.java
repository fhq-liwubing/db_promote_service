package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.TaskPackage;
import com.db.promote.param.PackageAddParam;
import com.db.promote.param.PackageQueryParam;
import com.db.promote.service.TaskService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.PackageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2019-01-06 10:40
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TaskService taskService;

    @GetMapping("/package/list")
    public JSONObject packageList() {
        PageInfo<TaskPackage> pageInfo = taskService
                .packagePageSearch(CommonUtil.requestToPageReq(request, PackageQueryParam.class));
        return CommonUtil.successPage(pageInfo, this::buildPackageVO);
    }

    @PostMapping("/package/add")
    public JSONObject packageAdd(@Validated @RequestBody PackageAddParam param) {
        taskService.packageAdd(param);
        return CommonUtil.successJson();
    }

    private PackageVO buildPackageVO(TaskPackage taskPackage) {
        PackageVO vo = new PackageVO();
        vo.setPackageNo(taskPackage.getPackageNo());
        vo.setPackageName(taskPackage.getPackageName());
        vo.setTaskType(taskPackage.getTaskType());
        vo.setTerminal(taskPackage.getTerminal());
        vo.setProcessStatus(taskPackage.getProcessStatus());
        vo.setFinishTime(DateUtil.format(taskPackage.getFinishTime()));
        vo.setRemark(taskPackage.getRemark());
        vo.setCreateTime(DateUtil.format(taskPackage.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(taskPackage.getUpdateTime()));
        return vo;
    }


}
