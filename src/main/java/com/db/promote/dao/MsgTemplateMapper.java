package com.db.promote.dao;

import com.db.promote.entity.MsgTemplate;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Mapper
public interface MsgTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgTemplate record);

    int insertSelective(MsgTemplate record);

    MsgTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgTemplate record);

    int updateByPrimaryKey(MsgTemplate record);
}