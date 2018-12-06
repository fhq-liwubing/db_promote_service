package com.db.promote.service.impl;

import com.db.promote.dao.TerminalMapper;
import com.db.promote.entity.Terminal;
import com.db.promote.service.TerminalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kun
 * @version 2018-12-06 19:25
 */
@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalMapper terminalMapper;

    @Override
    public PageInfo<Terminal> queryByExample(Terminal example, Integer pageNum, Integer pageRow) {
        return PageHelper.startPage(pageNum, pageRow).doSelectPageInfo(() -> terminalMapper.selectByExample(example));
    }


}
