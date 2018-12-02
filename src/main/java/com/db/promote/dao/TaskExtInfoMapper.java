package com.db.promote.dao;

import com.db.promote.entity.TaskExtInfo;

/**
* Created by Mybatis Generator 2018/12/02
*/
public interface TaskExtInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskExtInfo record);

    int insertSelective(TaskExtInfo record);

    TaskExtInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskExtInfo record);

    int updateByPrimaryKey(TaskExtInfo record);
}