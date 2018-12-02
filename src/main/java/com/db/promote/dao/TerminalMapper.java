package com.db.promote.dao;

import com.db.promote.entity.Terminal;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Mapper
public interface TerminalMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Terminal record);

    int insertSelective(Terminal record);

    Terminal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Terminal record);

    int updateByPrimaryKeyWithBLOBs(Terminal record);

    int updateByPrimaryKey(Terminal record);
}