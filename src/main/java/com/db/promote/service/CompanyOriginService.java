package com.db.promote.service;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.CompanyOrigin;

import java.util.List;

/**
 * Created by lib on 2018/12/3.
 */
public interface CompanyOriginService {

        void insert(CompanyOrigin input);

        /**
         * 客户资料列表
         * @param jsonObject
         * @return
         */
        JSONObject listCompanyOrigin(JSONObject jsonObject);

        /**
         * 根据省份查询
         * @param provinces
         * @return
         */
        List<CompanyOrigin> findCompanyByProvince(String provinces);
}
