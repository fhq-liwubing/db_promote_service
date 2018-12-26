package com.db.promote.dao;

import com.db.promote.entity.ContactBook;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Mapper
public interface ContactBookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContactBook record);

    int insertSelective(ContactBook record);

    ContactBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContactBook record);

    int updateByPrimaryKey(ContactBook record);
}