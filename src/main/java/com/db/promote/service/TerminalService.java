package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.Terminal;
import com.db.promote.param.AssignTerminalParam;
import com.db.promote.param.TerminalActivateParam;
import com.db.promote.param.TerminalQueryParam;
import com.db.promote.param.TerminalUpdateParam;
import com.db.promote.vo.TerminalVO;
import com.github.pagehelper.PageInfo;

/**
 * @author kun
 * @version 2018-12-28 14:36
 */
public interface TerminalService {
    void activate(TerminalActivateParam activateParam);

    void check(String imeiNo);

    PageInfo<Terminal> pageSearch(PageRequest<TerminalQueryParam> pageRequest);

    PageInfo<Terminal> assignPageSearch(PageRequest<AssignTerminalParam> pageRequest);

    void update(TerminalUpdateParam param);
}
