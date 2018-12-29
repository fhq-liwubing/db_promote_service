package com.db.promote.dao;

import com.db.promote.entity.RelEmployeeTerminal;
import com.db.promote.entity.Terminal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface RelEmployeeTerminalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RelEmployeeTerminal record);

    int insertSelective(RelEmployeeTerminal record);

    RelEmployeeTerminal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RelEmployeeTerminal record);

    int updateByPrimaryKey(RelEmployeeTerminal record);

    List<Terminal> selectTerminalsByEmployeeNo(String employeeNo);

}