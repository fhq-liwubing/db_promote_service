package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.EmployeeMapper;
import com.db.promote.entity.Employee;
import com.db.promote.param.EmployeeAddParam;
import com.db.promote.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author kun
 * @version 2018-12-26 21:34
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> pageSearch(PageRequest<Employee> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> employeeMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public void add(EmployeeAddParam param) {
        Employee employee = new Employee();
        String employeeNo = UUID.randomUUID().toString().replace("-", "");
        employee.setEmployeeNo(employeeNo);
        employee.setUsername(param.getUsername());
        employee.setSelfPhone(param.getSelfPhone());
        employee.setRemark(param.getRemark());
        employee.setState(1);
        employeeMapper.insertSelective(employee);
    }

}
