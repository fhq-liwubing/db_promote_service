package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.CdkeyMapper;
import com.db.promote.entity.Cdkey;
import com.db.promote.service.CdkeyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

/**
 * @author kun
 * @version 2018-12-27 21:40
 */
@Service
public class CdkeyServiceImpl implements CdkeyService {

    @Autowired
    private CdkeyMapper cdkeyMapper;

    @Override
    public void generate(int batchSize) {

        for (int i = 0; i < batchSize; i++) {
            Cdkey cdkey = new Cdkey();
            String key = UUID.randomUUID().toString().replace("-", "");
            cdkey.setCdkey(key);
            cdkey.setStatus(0);
            cdkey.setState(1);
            cdkey.setExpireTime(LocalDateTime.now().plus(1, ChronoUnit.YEARS));
            cdkeyMapper.insertSelective(cdkey);
        }

    }

    @Override
    public void send(Long id, String phone) {
        Cdkey cdkey = cdkeyMapper.selectByPrimaryKey(id);
        if (cdkey == null) {
            // TODO e
            return;
        }
        if (cdkey.getStatus() != 0) {
            // TODO e
            return;
        }

        // TODO send
        cdkey.setRecievePhone(phone);
        cdkeyMapper.updateByPrimaryKey(cdkey);

    }

    @Override
    public PageInfo<Cdkey> pageSearch(PageRequest<Cdkey> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> cdkeyMapper.selectByExample(pageRequest.getExample()));
    }

}
