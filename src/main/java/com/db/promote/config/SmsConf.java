package com.db.promote.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lib on 2018/12/28.
 * 短信配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "sms")
public class SmsConf {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 请求地址
     */
    private String reqUrl;

    /**
     * 签名
     */
    private String sign;
}
