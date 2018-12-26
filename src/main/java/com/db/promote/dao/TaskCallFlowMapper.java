package com.db.promote.dao;

import com.db.promote.entity.TaskCallFlow;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface TaskCallFlowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskCallFlow record);

    int insertSelective(TaskCallFlow record);

    TaskCallFlow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskCallFlow record);

    int updateByPrimaryKey(TaskCallFlow record);
}