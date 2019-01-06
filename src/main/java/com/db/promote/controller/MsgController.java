package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.MsgTemplate;
import com.db.promote.param.MsgTemplateAddParam;
import com.db.promote.param.MsgTemplateQueryParam;
import com.db.promote.param.MsgTemplateUpdateParam;
import com.db.promote.service.MsgTemplateService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.MsgTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2019-01-06 15:44
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private MsgTemplateService templateService;

    @GetMapping("/template/list")
    public JSONObject templateList() {
        return CommonUtil.successPage(
                templateService.pageSearch(CommonUtil.requestToPageReq(request, MsgTemplateQueryParam.class)),
                this::buildVO
        );
    }

    @PostMapping("/template/add")
    public JSONObject addTemplate(@Validated @RequestBody MsgTemplateAddParam param) {
        templateService.add(param);
        return CommonUtil.successJson();
    }

    @PostMapping("/template/update")
    public JSONObject updateTemplate(@Validated @RequestBody MsgTemplateUpdateParam param) {
        templateService.update(param);
        return CommonUtil.successJson();
    }

    private MsgTemplateVO buildVO(MsgTemplate template) {
        MsgTemplateVO vo = new MsgTemplateVO();
        vo.setTemplateNo(template.getTemplateNo());
        vo.setTemplateName(template.getTemplateName());
        vo.setTemplateType(template.getTemplateType());
        vo.setContent(template.getContent());
        vo.setRemark(template.getRemark());
        vo.setCreateTime(DateUtil.format(template.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(template.getUpdateTime()));
        return vo;
    }
}
