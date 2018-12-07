package com.db.promote.dao;

import com.db.promote.entity.City;
import com.db.promote.vo.CityVO;
import com.db.promote.vo.ProvinceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2018/12/07
*/
@Mapper
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<ProvinceVO> selectProvinces();

    List<CityVO> selectByFid(Integer fid);
}