package com.db.promote.dao;

import com.db.promote.entity.Company;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/08
 */
@Mapper
public interface CompanyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectByExample(Company example);

    Company selectByCompanyNo(String companyNo);

    List<Company> selectByCompanyNoIn(String[] companyNo);
}