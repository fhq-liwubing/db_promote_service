package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.component.SmsClint;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.CdkeyMapper;
import com.db.promote.entity.Cdkey;
import com.db.promote.param.CdkeyBatchGenerateParam;
import com.db.promote.service.CdkeyService;
import com.db.promote.util.constants.ErrorEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author kun
 * @version 2018-12-27 21:40
 */
@Service
public class CdkeyServiceImpl implements CdkeyService {

    @Autowired
    private CdkeyMapper cdkeyMapper;
    @Autowired
    private SmsClint smsClint;

    @Override
    public void generate(CdkeyBatchGenerateParam param) {

        for (int i = 0; i < param.getBatchSize(); i++) {
            Cdkey cdkey = newCdkey(param.getValidDays());
            cdkeyMapper.insertSelective(cdkey);
        }

    }

    @Override
    public void send(Long id, String phone) {
        Cdkey cdkey = cdkeyMapper.selectByPrimaryKey(id);
        if (cdkey == null) {
            throw new CommonJsonException(ErrorEnum.E_4000);
        }
        if (cdkey.getStatus() != 0) {
            throw new CommonJsonException(ErrorEnum.E_4004);
        }

        smsClint.sms(new String[]{phone}, String.format(SmsClint.CDKEY_TEMPLATE, cdkey.getCdkey()));
        cdkey.setReceivePhone(phone);
        cdkeyMapper.updateByPrimaryKey(cdkey);

    }

    @Override
    public void generateAndSend(String phone, Integer days) {
        Cdkey cdkey = newCdkey(days);
        cdkey.setReceivePhone(phone);

        smsClint.sms(new String[]{phone}, String.format(SmsClint.CDKEY_TEMPLATE, cdkey.getCdkey()));
        cdkeyMapper.insertSelective(cdkey);
    }

    @Override
    public PageInfo<Cdkey> pageSearch(PageRequest<Cdkey> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> cdkeyMapper.selectByExample(pageRequest.getExample()));
    }

    private Cdkey newCdkey(Integer days) {
        Cdkey cdkey = new Cdkey();
        String key = UUID.randomUUID().toString().replace("-", "");
        cdkey.setCdkey(key);
        cdkey.setValidateDays(days);
        cdkey.setStatus(0);
        cdkey.setState(1);
        return cdkey;
    }

}
