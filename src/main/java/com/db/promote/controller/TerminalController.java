package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.Terminal;
import com.db.promote.service.TerminalService;
import com.db.promote.util.CommonUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 * @version 2018-12-06 19:27
 */
@RequestMapping("/terminal")
@RestController
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @GetMapping("/listTerminal")
    public JSONObject listTerminal(@RequestBody JSONObject jsonObject) {
        PageInfo<Terminal> pageInfo = terminalService
                .queryByExample(jsonObject.toJavaObject(Terminal.class), jsonObject.getInteger("pageNum"), jsonObject.getInteger("pageRow"));
        return CommonUtil.successPage(pageInfo);
    }

}
