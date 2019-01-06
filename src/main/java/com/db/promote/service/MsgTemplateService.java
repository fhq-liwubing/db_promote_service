package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.MsgTemplate;
import com.db.promote.param.MsgTemplateAddParam;
import com.db.promote.param.MsgTemplateQueryParam;
import com.db.promote.param.MsgTemplateUpdateParam;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2019-01-06 15:43
 */
public interface MsgTemplateService {
    PageInfo<MsgTemplate> pageSearch(PageRequest<MsgTemplateQueryParam> pageRequest);

    void add(MsgTemplateAddParam param);

    void update(MsgTemplateUpdateParam param);
}
