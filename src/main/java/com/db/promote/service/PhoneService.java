package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Phone;
import com.db.promote.param.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-29 17:54
 */
public interface PhoneService {

    List<String> fuzzyQuery(String phoneNo);

    void add(PhoneAddParam param);

    void update(PhoneUpdateParam param);

    PageInfo<Phone> pageSearch(PageRequest<PhoneQueryParam> request);

    PageInfo<Phone> assignPageSearch(PageRequest<AssignPhoneParam> request);

    void assign(PhoneAssignParam param);
}
