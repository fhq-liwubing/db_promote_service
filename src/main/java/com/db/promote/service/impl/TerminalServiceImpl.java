package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.CdkeyMapper;
import com.db.promote.dao.EmployeeMapper;
import com.db.promote.dao.TerminalMapper;
import com.db.promote.entity.Cdkey;
import com.db.promote.entity.Employee;
import com.db.promote.entity.Terminal;
import com.db.promote.param.*;
import com.db.promote.service.TerminalService;
import com.db.promote.util.constants.ErrorEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kun
 * @version 2018-12-28 14:36
 */
@Service
@Transactional
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalMapper terminalMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CdkeyMapper cdkeyMapper;

    @Override
    public List<String> queryAll() {
        return terminalMapper.selectAll();
    }

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
        cdkey.setStatus(1);
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

    @Override
    public void update(TerminalUpdateParam param) {
        Terminal terminal = new Terminal();
        terminal.setTerminalNo(param.getTerminalNo());
        terminal.setState(param.getState());
        terminal.setProvince(param.getProvince());
        terminal.setCity(param.getCity());
        int i = terminalMapper.updateByPrimaryKeySelective(terminal);
        if (i == 0) {
            throw new CommonJsonException(ErrorEnum.E_4000);
        }
    }

    @Override
    public void assign(TerminalAssignParam param) {
        final String employeeNo = param.getEmployeeNo();
        final String username = param.getUsername();
        final String[] terminalNos = param.getTerminalNos();

        if (StringUtils.isBlank(employeeNo) && StringUtils.isBlank(username)) {
            throw new CommonJsonException(ErrorEnum.E_90003, "缺少员工信息");
        }

        Employee employee = null;
        if (StringUtils.isNotBlank(employeeNo)) {
            employee = employeeMapper.selectByEmployeeNo(employeeNo);
        }
        if (StringUtils.isNotBlank(username)) {
            List<Employee> employees = employeeMapper.selectByUsername(username);
            if (employees.size() > 1) {
                throw new CommonJsonException(ErrorEnum.E_4009);
            }
            if (!employees.isEmpty()) {
                employee = employees.get(0);
            }
        }
        if (employee == null) {
            throw new CommonJsonException(ErrorEnum.E_4000, "员工不存在，请重新指定");
        }
        List<Terminal> terminals = terminalMapper.selectByTerminalNos(terminalNos);
        if (terminalNos.length != terminals.size()) {
            throw new CommonJsonException(ErrorEnum.E_4000, "缺少设备信息");
        }

        LocalDateTime now = LocalDateTime.now();
        for (Terminal terminal : terminals) {
            terminal.setAssignTime(now);
            terminal.setEmployeeNo(employeeNo);
            terminalMapper.updateByPrimaryKeySelective(terminal);
        }
    }

}
