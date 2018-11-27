package com.db.promote.dao;

import com.db.promote.entity.Commpay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommpayDao {
    int insert(@Param("pojo") Commpay pojo);

    int insertSelective(@Param("pojo") Commpay pojo);

    int insertList(@Param("pojos") List<Commpay> pojo);

    int update(@Param("pojo") Commpay pojo);
}
