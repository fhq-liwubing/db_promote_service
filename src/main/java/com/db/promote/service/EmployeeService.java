package com.db.promote.service;

import com.db.promote.entity.Employee;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-06 17:52
 */
public interface EmployeeService {

    PageInfo<Employee> queryByExample(Employee example, Integer pageNum, Integer pageRow);

}
