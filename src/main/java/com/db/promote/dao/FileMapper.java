package com.db.promote.dao;

import com.db.promote.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Mapper
public interface FileMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    List<File> selectByExample(File example);
}