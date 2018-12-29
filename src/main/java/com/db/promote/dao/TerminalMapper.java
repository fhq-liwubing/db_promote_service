package com.db.promote.dao;

import com.db.promote.entity.Terminal;
import com.db.promote.vo.TerminalVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/29
 */
@Mapper
public interface TerminalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Terminal record);

    int insertSelective(Terminal record);

    Terminal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Terminal record);

    int updateByPrimaryKey(Terminal record);

    Terminal selectByImeiNo(String imeiNo);

    List<Terminal> selectByEmployeeNo(String employeeNo);

    List<Terminal> selectByExample(TerminalVO example);
}