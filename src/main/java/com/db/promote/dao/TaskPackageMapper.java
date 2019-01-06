package com.db.promote.dao;

import com.db.promote.entity.TaskPackage;
import com.db.promote.param.PackageQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface TaskPackageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskPackage record);

    int insertSelective(TaskPackage record);

    TaskPackage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskPackage record);

    int updateByPrimaryKey(TaskPackage record);

    List<TaskPackage> selectByExample(PackageQueryParam param);
}