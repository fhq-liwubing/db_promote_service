package com.db.promote.dao;

import com.db.promote.entity.Phone;
import com.db.promote.param.PhoneQueryParam;import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/29
 */
@Mapper
public interface PhoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);

    List<Phone> selectByExample(PhoneQueryParam param);
}