package com.db.promote.common;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by lib on 2018/12/3.
 * 发送短信的类型
 */

public enum SmsTypeEnum {
     MARKETING("2", "营销短信"),
     MEMBER_MARKETING("1", "会员营销"),
     NOTICE("0", "验证码通知"),
    ;

    private String code;
    private String msg;

    SmsTypeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static SmsTypeEnum getMsg(String code) {
        Optional<SmsTypeEnum> errorOp = Arrays.asList(SmsTypeEnum.values())
                                              .stream().filter(sourceTypeEnum ->
                        sourceTypeEnum.getCode().equals(code)).findAny();
        return errorOp.orElse(null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
