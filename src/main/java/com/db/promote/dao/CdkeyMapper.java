package com.db.promote.dao;

import com.db.promote.entity.Cdkey;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/29
 */
@Mapper
public interface CdkeyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cdkey record);

    int insertSelective(Cdkey record);

    Cdkey selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cdkey record);

    int updateByPrimaryKey(Cdkey record);

    List<Cdkey> selectByExample(Cdkey example);

    Cdkey selectByCdkey(String cdkey);
}