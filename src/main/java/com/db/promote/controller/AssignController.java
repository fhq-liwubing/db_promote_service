package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Terminal;
import com.db.promote.param.AssignTerminalParam;
import com.db.promote.service.TerminalService;
import com.db.promote.util.CommonUtil;
import com.db.promote.vo.AssignTerminalVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/phone/list")
    public JSONObject phoneList() {
        return null;
    }

    @GetMapping("/terminal/list")
    public JSONObject terminalList(HttpServletRequest request) {
        PageInfo<Terminal> pageInfo = terminalService
                .assignPageSearch(CommonUtil.requestToPageReq(request, AssignTerminalParam.class));
        return CommonUtil.successPage(pageInfo, this::buildTerminalVO);
    }

    private AssignTerminalVO buildTerminalVO(Terminal terminal) {
        AssignTerminalVO vo = new AssignTerminalVO();
        vo.setTerminalNo(terminal.getTerminalNo());
        vo.setEmployeeNo(terminal.getEmployeeNo());
        vo.setEmployeeName(terminal.getEmployee().getUsername());
        vo.setAssignTime(terminal.getAssignTime());
        return vo;
    }
}
