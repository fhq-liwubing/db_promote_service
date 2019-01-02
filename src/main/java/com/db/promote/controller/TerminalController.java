package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Terminal;
import com.db.promote.param.TerminalActivateParam;
import com.db.promote.param.TerminalQueryParam;
import com.db.promote.param.TerminalUpdateParam;
import com.db.promote.service.TerminalService;
import com.db.promote.util.CommonUtil;
import com.db.promote.vo.TerminalVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kun
 * @version 2018-12-28 14:35
 */
@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @PostMapping("/activate")
    public JSONObject activate(@Validated @RequestBody TerminalActivateParam param) {
        terminalService.activate(param);
        return CommonUtil.successJson();
    }

    @GetMapping("/check/{imei}")
    public JSONObject check(@PathVariable String imei) {
        terminalService.check(imei);
        return CommonUtil.successJson();
    }

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        PageInfo<Terminal> pageInfo = terminalService
                .pageSearch(CommonUtil.requestToPageReq(request, TerminalQueryParam.class));
        return CommonUtil.successPage(pageInfo, this::buildVO);
    }

    @PostMapping("/update")
    public JSONObject update(TerminalUpdateParam param) {
        terminalService.update(param);
        return CommonUtil.successJson();
    }

    private TerminalVO buildVO(Terminal terminal) {
        TerminalVO vo = new TerminalVO();
        vo.setTerminalNo(terminal.getTerminalNo());
        vo.setEmployeeName(terminal.getEmployee() == null ? null : terminal.getEmployee().getUsername());
        vo.setImeiNo(terminal.getImeiNo());
        vo.setCdkey(terminal.getCdkey());
        vo.setExpireTime(terminal.getExpireTime());
        vo.setProvince(terminal.getProvince());
        vo.setCity(terminal.getCity());
        vo.setRemark(terminal.getRemark());
        vo.setState(terminal.getState());
        vo.setCreateTime(terminal.getCreateTime());
        vo.setUpdateTime(terminal.getUpdateTime());
        return vo;
    }
}

