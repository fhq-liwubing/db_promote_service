package com.db.promote.dao;

import com.db.promote.entity.CompanyOrigin;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Mapper
public interface CompanyOriginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyOrigin record);

    int insertSelective(CompanyOrigin record);

    CompanyOrigin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyOrigin record);

    int updateByPrimaryKey(CompanyOrigin record);
}