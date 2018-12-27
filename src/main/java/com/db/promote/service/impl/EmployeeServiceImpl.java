package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.EmployeeMapper;
import com.db.promote.entity.Employee;
import com.db.promote.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kun
 * @version 2018-12-26 21:34
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> pageSearch(PageRequest<Employee> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> employeeMapper.selectByExample(pageRequest.getExample()));
    }

}
