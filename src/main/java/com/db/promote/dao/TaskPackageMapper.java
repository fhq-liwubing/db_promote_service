package com.db.promote.dao;

import com.db.promote.entity.TaskPackage;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/07
 */
@Mapper
public interface TaskPackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskPackage record);

    int insertSelective(TaskPackage record);

    TaskPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskPackage record);

    int updateByPrimaryKey(TaskPackage record);

    List<TaskPackage> selectByExample(TaskPackage example);
}