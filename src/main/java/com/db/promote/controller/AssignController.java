package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Phone;
import com.db.promote.entity.Terminal;
import com.db.promote.param.AssignPhoneParam;
import com.db.promote.param.AssignTerminalParam;
import com.db.promote.param.PhoneAssignParam;
import com.db.promote.param.TerminalAssignParam;
import com.db.promote.service.PhoneService;
import com.db.promote.service.TerminalService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.AssignPhoneVO;
import com.db.promote.vo.AssignTerminalVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-29 17:14
 */
@RestController
@RequestMapping("/assignation")
public class AssignController {

    @Autowired
    private TerminalService terminalService;
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phone/list")
    public JSONObject phoneList(HttpServletRequest request) {
        PageInfo<Phone> pageInfo = phoneService
                .assignPageSearch(CommonUtil.requestToPageReq(request, AssignPhoneParam.class));
        return CommonUtil.successPage(pageInfo, this::buildPhoneVO);
    }

    @PostMapping("/phone/assign")
    public JSONObject phoneAssign(@Validated @RequestBody PhoneAssignParam param) {
        phoneService.assign(param);
        return CommonUtil.successJson();
    }

    @GetMapping("/terminal/list")
    public JSONObject terminalList(HttpServletRequest request) {
        PageInfo<Terminal> pageInfo = terminalService
                .assignPageSearch(CommonUtil.requestToPageReq(request, AssignTerminalParam.class));
        return CommonUtil.successPage(pageInfo, this::buildTerminalVO);
    }

    @PostMapping("/terminal/assign")
    public JSONObject terminalAssign(@Validated @RequestBody TerminalAssignParam param) {
        terminalService.assign(param);
        return CommonUtil.successJson();
    }

    private AssignPhoneVO buildPhoneVO(Phone phone) {
        AssignPhoneVO vo = new AssignPhoneVO();
        vo.setTerminalNo(phone.getTerminalNo());
        vo.setPhoneNo(phone.getPhoneNo());
        vo.setAssignTime(DateUtil.format(phone.getAssignTime()));
        return vo;
    }

    private AssignTerminalVO buildTerminalVO(Terminal terminal) {
        AssignTerminalVO vo = new AssignTerminalVO();
        vo.setTerminalNo(terminal.getTerminalNo());
        vo.setEmployeeNo(terminal.getEmployeeNo());
        if (terminal.getEmployee() != null) {
            vo.setEmployeeName(terminal.getEmployee().getUsername());
        }
        if(terminal.getAssignTime() !=null){

            vo.setAssignTime(DateUtil.format(terminal.getAssignTime()));
        }
        return vo;
    }
}
