package com.db.promote.dao;

import com.db.promote.entity.File;
import com.db.promote.param.FileQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Mapper
public interface FileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    List<File> selectByExample(FileQueryParam param);

    List<File> selectAll(String terminalNo);
}