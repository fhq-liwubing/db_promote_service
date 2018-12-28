package com.db.promote.component;

import com.db.promote.common.SmsTypeEnum;
import com.db.promote.config.SmsConf;
import com.db.promote.entity.vo.SmsVo;
import com.db.promote.util.Base64;
import com.db.promote.util.GsonUtil;
import com.db.promote.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by lib on 2018/12/28.
 * 发送短信
 */
@Slf4j
@Component
public class SmsClint {

    @Autowired
    private SmsConf smsConf;

    /**
     * 发送短信
     * @param smsTypeEnum 短信类型
     * @param mobile 接受方手机号，数组
     * @param content 短信内容
     * @return
     */
    public SmsVo sms(SmsTypeEnum smsTypeEnum, String[] mobile, String content) {

        SmsVo smsVo = new SmsVo();

        //校验请求参数
        if (mobile == null || mobile.length == 0) {
            smsVo.setCode("-1");
            smsVo.setMsg("手机号不能为空！");
            return smsVo;
        } else if (StringUtils.isBlank(content)) {
            smsVo.setCode("-1");
            smsVo.setMsg("短信内容不能为空！");
            return smsVo;
        } else if (smsTypeEnum == null) {
            smsVo.setCode("-1");
            smsVo.setMsg("短信类型不能为空！");
            return smsVo;
        }

        HashMap<String, String> param = new HashMap();
        param.put("method", "sendSMS");
        param.put("username", smsConf.getUserName());//用户名
        //密码，这里要采用BASE64 加密算法
        param.put("password", Base64.encode(smsConf.getPassWord().getBytes()));
        param.put("smstype", smsTypeEnum.getCode());//发送短信的类型
        param.put("mobile", bulidMobile(mobile)); //手机号
        param.put("content", smsConf.getSign() + content);//发送短信内容
        param.put("isLongSms", "0"); // 0-普通短信 1-加长短信
//        param.put("extenno", "");//为通道扩展子号码，可以为空
        log.info("发送短信请求参数：{}",GsonUtil.buildGson().toJson(param));
        String result = HttpUtil.post(smsConf.getReqUrl(), param);
        log.info("发送短信返回参数：{}", result);
        if(!StringUtils.isBlank(result)){
            String [] response = result.split(";");
            if("success".equals(response[0])){
                smsVo.setCode(SmsVo.SUCCESS);
                smsVo.setMsg("发送成功");
            }else{
                smsVo.setCode(response[0]);
                smsVo.setMsg(response[1]);
            }
        }else{
            smsVo.setCode("fail");
            smsVo.setMsg("短信方异常，未返回结果！");
        }
        return smsVo;
    }

    private String buildBase64(String passWord){
        return Base64.encode(passWord.getBytes());
    }

    /**
     * 将数组转为拼接字符串
     * 比如：["1111","2222"],转为：1111,2222
     *
     * @param mobile
     * @return
     */
    private String bulidMobile(String[] mobile) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < mobile.length; i++) {
            if (!StringUtils.isBlank(str)) {
                str.append(",");
            }
            str.append(mobile[i]);
        }
        return str.toString();
    }


}
