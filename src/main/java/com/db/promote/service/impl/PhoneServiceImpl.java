package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.PhoneMapper;
import com.db.promote.dao.TerminalMapper;
import com.db.promote.entity.Phone;
import com.db.promote.entity.Terminal;
import com.db.promote.param.*;
import com.db.promote.service.PhoneService;
import com.db.promote.util.constants.ErrorEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author kun
 * @version 2018-12-29 17:54
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;
    @Autowired
    private TerminalMapper terminalMapper;

    @Override
    public List<String> queryAll() {
        return phoneMapper.selectAll();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void add(PhoneAddParam param) {
        Phone phone = new Phone();
        phone.setPhoneNo(param.getPhoneNo());
        phone.setIdCardNo(param.getIdCardNo());
        phone.setOwnerName(param.getOwnerName());
        phone.setDataRemain(param.getDataRemain());
        phone.setCallRemain(param.getCallRemain());
        phone.setMsgRemain(param.getMsgRemain());
        phone.setWechatName(param.getWechatName());
        phone.setWechatNo(param.getWechatNo());
        phone.setPayPassword(param.getPayPassword());
        phone.setState(1);
        phoneMapper.insertSelective(phone);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void update(PhoneUpdateParam param) {
        Phone phone = new Phone();
        phone.setPhoneNo(param.getPhoneNo());
        phone.setIdCardNo(param.getIdCardNo());
        phone.setOwnerName(param.getOwnerName());
        phone.setDataRemain(param.getDataRemain());
        phone.setCallRemain(param.getCallRemain());
        phone.setMsgRemain(param.getMsgRemain());
        phone.setWechatName(param.getWechatName());
        phone.setWechatNo(param.getWechatNo());
        phone.setPayPassword(param.getPayPassword());
        phone.setState(param.getState());
        int i = phoneMapper.updateByPhoneNo(phone);
        if (i == 0) {
            throw new CommonJsonException(ErrorEnum.E_4000);
        }
    }

    @Override
    public PageInfo<Phone> pageSearch(PageRequest<PhoneQueryParam> request) {
        return PageHelper.startPage(request.getPageNum(), request.getPageRow())
                .doSelectPageInfo(() -> phoneMapper.selectByExample(request.getExample()));
    }

    @Override
    public PageInfo<Phone> assignPageSearch(PageRequest<AssignPhoneParam> request) {
        return PageHelper.startPage(request.getPageNum(), request.getPageRow())
                .doSelectPageInfo(() -> phoneMapper.selectByExampleForAssign(request.getExample()));
    }

    @Override
    public void assign(PhoneAssignParam param) {
        Terminal terminal = terminalMapper.selectByTerminalNo(param.getTerminalNo());
        if (terminal == null) {
            throw new CommonJsonException(ErrorEnum.E_4000, "设备信息不存在");
        }
        List<Phone> phones = phoneMapper.selectByPhoneNos(param.getPhoneNos());
        if (phones.size() != param.getPhoneNos().length) {
            throw new CommonJsonException(ErrorEnum.E_4000, "缺少手机号码信息");
        }
        LocalDateTime now = LocalDateTime.now();
        for (Phone phone : phones) {
            phone.setTerminalNo(param.getTerminalNo());
            phone.setAssignTime(now);
            phoneMapper.updateByPrimaryKeySelective(phone);
        }
    }

}
