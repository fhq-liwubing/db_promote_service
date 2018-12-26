package com.db.promote.dao;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.CompanyOrigin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyOriginDao {

    int insert(@Param("pojo") CompanyOrigin pojo);

    int insertSelective(@Param("pojo") CompanyOrigin pojo);

    int insertList(@Param("pojos") List<CompanyOrigin> pojo);

    int update(@Param("pojo") CompanyOrigin pojo);

    /**
     * 客户资料来源列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> listCompanyOrigin(JSONObject jsonObject);

    /**
     * 统计客户资料来源总数
     *
     * @param jsonObject
     * @return
     */
    int countCompanyOrigin(JSONObject jsonObject);
}
