package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Employee;
import com.db.promote.service.EmployeeService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-06 18:05
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/listEmployee")
    public JSONObject listEmployee(HttpServletRequest request) {
        JSONObject jsonObject = CommonUtil.request2Json(request);
        Employee employee = jsonObject.toJavaObject(Employee.class);
        PageInfo<Employee> pageInfo = employeeService.queryByExample(employee, jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(pageInfo.getList(), pageInfo.getPages(), pageInfo.getTotal());
    }

}
