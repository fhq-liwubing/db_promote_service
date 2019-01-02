package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Cdkey;
import com.db.promote.param.CdkeyBatchGenerateParam;
import com.db.promote.service.CdkeyService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.CdkeyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-27 21:19
 */
@RestController
@RequestMapping("/cdkey")
public class CdkeyController {

    @Autowired
    private CdkeyService cdkeyService;

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        return CommonUtil.successPage(
                cdkeyService.pageSearch(CommonUtil.requestToPageReq(request, Cdkey.class)),
                this::buildVO
        );
    }

    @PostMapping("/generate/batch")
    public JSONObject generate(@RequestBody @Validated CdkeyBatchGenerateParam param) {
        cdkeyService.generate(param);
        return CommonUtil.successJson();
    }

    @PostMapping("/generate/send/{phone}/{days}")
    public JSONObject generateAndSend(@PathVariable String phone, @PathVariable Integer days) {
        cdkeyService.generateAndSend(phone, days);
        return CommonUtil.successJson();
    }

    @PutMapping("/send/{id}/{phone}")
    public JSONObject send(@PathVariable("id") Long id, @PathVariable("phone") String phone) {
        cdkeyService.send(id, phone);
        return CommonUtil.successJson();
    }

    private CdkeyVO buildVO(Cdkey cdkey) {
        CdkeyVO vo = new CdkeyVO();
        vo.setCdkey(cdkey.getCdkey());
        vo.setReceivePhone(cdkey.getReceivePhone());
        vo.setReceiveEmail(cdkey.getReceiveEmail());
        vo.setStatus(cdkey.getStatus());
        vo.setValidateDays(cdkey.getValidateDays());
        vo.setRemark(cdkey.getRemark());
        vo.setCreateTime(DateUtil.format(cdkey.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(cdkey.getUpdateTime()));
        return vo;
    }

}
