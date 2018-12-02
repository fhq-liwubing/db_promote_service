package com.db.promote.dao;

import com.db.promote.entity.TerminalPackageRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Mapper
public interface TerminalPackageRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TerminalPackageRelation record);

    int insertSelective(TerminalPackageRelation record);

    TerminalPackageRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TerminalPackageRelation record);

    int updateByPrimaryKey(TerminalPackageRelation record);
}