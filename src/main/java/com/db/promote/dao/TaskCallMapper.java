package com.db.promote.dao;

import com.db.promote.entity.TaskCall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Mapper
public interface TaskCallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskCall record);

    int insertSelective(TaskCall record);

    TaskCall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskCall record);

    int updateByPrimaryKey(TaskCall record);

    void insertList(List<TaskCall> list);
}