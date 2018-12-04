package com.db.promote.dao;

import com.db.promote.entity.Task;

/**
 * Created by Mybatis Generator 2018/12/04
 */
public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}