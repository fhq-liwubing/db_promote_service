package com.db.promote.dao;

import com.db.promote.entity.MsgTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface MsgTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgTemplate record);

    int insertSelective(MsgTemplate record);

    MsgTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MsgTemplate record);

    int updateByPrimaryKey(MsgTemplate record);
}