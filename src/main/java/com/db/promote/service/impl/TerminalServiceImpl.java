package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.CdkeyMapper;
import com.db.promote.dao.TerminalMapper;
import com.db.promote.entity.Cdkey;
import com.db.promote.entity.Terminal;
import com.db.promote.param.AssignTerminalParam;
import com.db.promote.param.TerminalActivateParam;
import com.db.promote.param.TerminalQueryParam;
import com.db.promote.service.TerminalService;
import com.db.promote.util.constants.ErrorEnum;
import com.db.promote.vo.TerminalVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2018-12-28 14:36
 */
@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalMapper terminalMapper;
    @Autowired
    private CdkeyMapper cdkeyMapper;

    @Override
    public void activate(TerminalActivateParam activateParam) {

        Cdkey cdkey = cdkeyMapper.selectByCdkey(activateParam.getCdkey());
        if (cdkey == null) {
            throw new CommonJsonException(ErrorEnum.E_4000, "激活码不存在");
        }
        if (cdkey.getStatus() != 0) {
            throw new CommonJsonException(ErrorEnum.E_4004);
        }

        cdkey.setActTerminal(activateParam.getIdentityNo());
        cdkeyMapper.updateByPrimaryKeySelective(cdkey);

        Terminal terminal = new Terminal();
        terminal.setTerminalNo(activateParam.getIdentityNo());
        terminal.setCdkey(activateParam.getCdkey());
        terminal.setExpireTime(LocalDateTime.now().plusDays(cdkey.getValidateDays()));
        terminal.setProvince(activateParam.getProvince());
        terminal.setCity(activateParam.getCity());
        terminal.setImeiNo(activateParam.getImeiNo());
        terminalMapper.insertSelective(terminal);
    }

    @Override
    public void check(String imeiNo) {

        Terminal terminal = terminalMapper.selectByImeiNo(imeiNo);
        if (terminal == null) {
            throw new CommonJsonException(ErrorEnum.E_4006);
        }
        if (terminal.getState() != 1) {
            throw new CommonJsonException(ErrorEnum.E_4007);
        }
        if (terminal.getExpireTime().isBefore(LocalDateTime.now())) {
            throw new CommonJsonException(ErrorEnum.E_4005);
        }
        String key = terminal.getCdkey();
        Cdkey cdkey = cdkeyMapper.selectByCdkey(key);
        if (cdkey == null || cdkey.getStatus() == 0) {
            throw new CommonJsonException(ErrorEnum.E_4008);
        }
    }

    @Override
    public PageInfo<Terminal> pageSearch(PageRequest<TerminalQueryParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> terminalMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public PageInfo<Terminal> assignPageSearch(PageRequest<AssignTerminalParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> terminalMapper.selectByExampleForAssign(pageRequest.getExample()));
    }

}
