package com.db.promote.service;

import com.db.promote.entity.Terminal;
import com.db.promote.vo.TerminalVO;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-06 19:25
 */
public interface TerminalService {

    PageInfo<Terminal> queryByExample(Terminal example, Integer pageNum, Integer pageRow);

    PageInfo<TerminalVO> queryVOByExample(TerminalVO example, Integer pageNum, Integer pageRow);
}
