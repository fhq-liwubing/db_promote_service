package com.db.promote.dao;

import com.db.promote.entity.Employee;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/06
 */
@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectByExample(Employee example);
}