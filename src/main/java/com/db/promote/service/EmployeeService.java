package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Employee;
import com.db.promote.param.EmployeeAddParam;
import com.db.promote.param.EmployeeUpdateParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-26 21:34
 */
public interface EmployeeService {

    PageInfo<Employee> pageSearch(PageRequest<Employee> pageRequest);

    void add(EmployeeAddParam param);

    void update(EmployeeUpdateParam param);

    List<Employee> getAll();
}
