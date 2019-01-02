package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Employee;
import com.db.promote.param.EmployeeAddParam;
import com.db.promote.param.EmployeeUpdateParam;
import com.db.promote.service.EmployeeService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.EmployeeVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("/list/all")
    public JSONObject all() {
        List<Employee> all = employeeService.getAll();
        return CommonUtil.successList(all);
    }

    @PostMapping("/add")
    public JSONObject add(@Validated @RequestBody EmployeeAddParam param) {
        employeeService.add(param);
        return CommonUtil.successJson();
    }

    @PostMapping("/update")
    public JSONObject update(@Validated @RequestBody EmployeeUpdateParam param) {
        employeeService.update(param);
        return CommonUtil.successJson();
    }

    private EmployeeVO buildVO(Employee employee) {
        EmployeeVO vo = new EmployeeVO();
        vo.setEmployeeNo(employee.getEmployeeNo());
        vo.setUsername(employee.getUsername());
        vo.setSelfPhone(employee.getSelfPhone());
        vo.setRemark(employee.getRemark());
        vo.setState(employee.getState());
        vo.setTerminalCount(employee.getTerminals().size());
        vo.setCreateTime(DateUtil.format(employee.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(employee.getUpdateTime()));
        return vo;
    }

}
