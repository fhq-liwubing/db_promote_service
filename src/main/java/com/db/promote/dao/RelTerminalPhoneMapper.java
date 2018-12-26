package com.db.promote.dao;

import com.db.promote.entity.RelTerminalPhone;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface RelTerminalPhoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RelTerminalPhone record);

    int insertSelective(RelTerminalPhone record);

    RelTerminalPhone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RelTerminalPhone record);

    int updateByPrimaryKey(RelTerminalPhone record);
}