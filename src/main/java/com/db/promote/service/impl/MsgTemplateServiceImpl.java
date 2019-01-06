package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.MsgTemplateMapper;
import com.db.promote.entity.MsgTemplate;
import com.db.promote.param.MsgTemplateAddParam;
import com.db.promote.param.MsgTemplateQueryParam;
import com.db.promote.param.MsgTemplateUpdateParam;
import com.db.promote.service.MsgTemplateService;
import com.db.promote.util.constants.ErrorEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author kun
 * @version 2019-01-06 15:43
 */
@Service
public class MsgTemplateServiceImpl implements MsgTemplateService {

    @Autowired
    private MsgTemplateMapper msgTemplateMapper;

    @Override
    public PageInfo<MsgTemplate> pageSearch(PageRequest<MsgTemplateQueryParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> msgTemplateMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public void add(MsgTemplateAddParam param) {
        MsgTemplate template = new MsgTemplate();
        template.setTemplateNo(UUID.randomUUID().toString().replace("-", ""));
        template.setTemplateName(param.getTemplateName());
        template.setTemplateType(param.getTemplateType());
        template.setContent(param.getContent());
        template.setParamSize(StringUtils.countMatches(param.getContent(), "%s"));
        template.setState(1);
        template.setRemark(param.getRemark());
        msgTemplateMapper.insertSelective(template);
    }

    @Override
    public void update(MsgTemplateUpdateParam param) {
        MsgTemplate template = msgTemplateMapper.selectByTemplateNo(param.getTemplateNo());
        if (template == null) {
            throw new CommonJsonException(ErrorEnum.E_4000, "模板信息不存在");
        }
        template.setTemplateName(param.getTemplateName());
        template.setTemplateType(param.getTemplateType());
        if (StringUtils.isNotBlank(param.getContent())) {
            template.setContent(param.getContent());
            template.setParamSize(StringUtils.countMatches(param.getContent(), "%s"));
        }
        template.setState(param.getState());
        template.setRemark(param.getRemark());
        msgTemplateMapper.updateByPrimaryKeySelective(template);
    }

}
