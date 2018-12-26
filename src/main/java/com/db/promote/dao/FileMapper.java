package com.db.promote.dao;

import com.db.promote.entity.File;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface FileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}