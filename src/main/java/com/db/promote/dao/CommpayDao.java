package com.db.promote.dao;

import com.db.promote.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommpayDao {
    int insert(@Param("pojo") Company pojo);

    int insertSelective(@Param("pojo") Company pojo);

    int insertList(@Param("pojos") List<Company> pojo);

    int update(@Param("pojo") Company pojo);
}
