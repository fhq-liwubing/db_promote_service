package com.db.promote.dao;

import com.db.promote.entity.MsgTemplate;
import com.db.promote.param.MsgTemplateQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    List<MsgTemplate> selectByExample(MsgTemplateQueryParam param);

    MsgTemplate selectByTemplateNo(String templateNo);
}