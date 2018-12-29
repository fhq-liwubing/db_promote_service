package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Phone;
import com.db.promote.param.PhoneQueryParam;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-29 17:54
 */
public interface PhoneService {
    PageInfo<Phone> pageSearch(PageRequest<PhoneQueryParam> request);
}
