package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.PhoneMapper;
import com.db.promote.entity.Phone;
import com.db.promote.param.PhoneQueryParam;
import com.db.promote.service.PhoneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kun
 * @version 2018-12-29 17:54
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    public PageInfo<Phone> pageSearch(PageRequest<PhoneQueryParam> request) {
        return PageHelper.startPage(request.getPageNum(), request.getPageRow())
                .doSelectPageInfo(() -> phoneMapper.selectByExample(request.getExample()));
    }

}
