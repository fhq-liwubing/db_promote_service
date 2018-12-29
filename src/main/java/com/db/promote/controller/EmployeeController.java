package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Employee;
import com.db.promote.service.EmployeeService;
import com.db.promote.util.CommonUtil;
import com.db.promote.vo.EmployeeVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-26 22:14
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        PageInfo<Employee> pageInfo = employeeService.pageSearch(CommonUtil.requestToPageReq(request, Employee.class));
        return CommonUtil.successPage(pageInfo, this::buildVO);
    }

    private EmployeeVO buildVO(Employee employee) {
        EmployeeVO vo = new EmployeeVO();
        vo.setEmployeeNo(employee.getEmployeeNo());
        vo.setUsername(employee.getUsername());
        vo.setSelfPhone(employee.getSelfPhone());
        vo.setRemark(employee.getRemark());
        vo.setState(employee.getState());
        vo.setTerminalCount(employee.getTerminals().size());
        vo.setCreateTime(employee.getCreateTime());
        vo.setUpdateTime(employee.getUpdateTime());
        return vo;
    }

}
