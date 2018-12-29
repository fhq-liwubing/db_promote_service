package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Cdkey;
import com.db.promote.param.CdkeyBatchGenerateParam;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-27 21:40
 */
public interface CdkeyService {

    void generate(CdkeyBatchGenerateParam param);

    void send(Long id, String phone);

    void generateAndSend(String phone, Integer days);

    PageInfo<Cdkey> pageSearch(PageRequest<Cdkey> pageRequest);

}
