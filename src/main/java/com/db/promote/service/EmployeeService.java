package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Employee;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-26 21:34
 */
public interface EmployeeService {


    PageInfo<Employee> pageSearch(PageRequest<Employee> pageRequest);
}
