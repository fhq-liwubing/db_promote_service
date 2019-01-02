package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Phone;
import com.db.promote.param.PhoneAddParam;
import com.db.promote.param.PhoneQueryParam;
import com.db.promote.param.PhoneUpdateParam;
import com.db.promote.service.PhoneService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.PhoneVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-29 17:55
 */
@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        PageInfo<Phone> pageInfo = phoneService
                .pageSearch(CommonUtil.requestToPageReq(request, PhoneQueryParam.class));
        return CommonUtil.successPage(pageInfo, this::buildVO);
    }

    @PostMapping("/add")
    public JSONObject add(@Validated @RequestBody PhoneAddParam param) {
        phoneService.add(param);
        return CommonUtil.successJson();
    }

    @PutMapping("/update")
    public JSONObject update(@Validated @RequestBody PhoneUpdateParam param) {
        phoneService.update(param);
        return CommonUtil.successJson();
    }

    private PhoneVO buildVO(Phone phone) {
        PhoneVO vo = new PhoneVO();
        vo.setPhoneNo(phone.getPhoneNo());
        vo.setTerminalNo(phone.getTerminalNo());
        vo.setDataRemain(phone.getDataRemain());
        vo.setCallRemain(phone.getCallRemain());
        vo.setMsgRemain(phone.getMsgRemain());
        vo.setOwnerName(phone.getOwnerName());
        vo.setIdCardNo(phone.getIdCardNo());
        vo.setWechatName(phone.getWechatName());
        vo.setWechatNo(phone.getWechatNo());
        vo.setPayPassword(phone.getPayPassword());
        vo.setAssignTime(phone.getAssignTime() == null ? null : DateUtil.format(phone.getAssignTime()));
        vo.setState(phone.getState());
        vo.setRemark(phone.getRemark());
        vo.setCreateTime(DateUtil.format(phone.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(phone.getUpdateTime()));
        return vo;
    }


}
