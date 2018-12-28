package com.db.promote.test;

import com.db.promote.common.SmsTypeEnum;
import com.db.promote.component.SmsClint;
import com.db.promote.entity.vo.SmsVo;
import com.db.promote.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lib on 2018/12/28.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsTest {

    @Autowired
    private SmsClint smsClint;

    @Test
    public void sms (){
        String[] mobile = {"18500215","18500215239"};
        SmsVo smsVo = smsClint.sms(SmsTypeEnum.NOTICE,mobile,"您的激活码为：XXXX,请注意妥善保管");
        log.info("最终结果：{}",GsonUtil.buildGson().toJson(smsVo));
    }
}
