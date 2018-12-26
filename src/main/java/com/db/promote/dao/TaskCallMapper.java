package com.db.promote.dao;

import com.db.promote.entity.TaskCall;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface TaskCallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskCall record);

    int insertSelective(TaskCall record);

    TaskCall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskCall record);

    int updateByPrimaryKey(TaskCall record);
}