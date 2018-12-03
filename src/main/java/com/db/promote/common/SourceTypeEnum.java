package com.db.promote.common;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by lib on 2018/12/3.
 */

public enum SourceTypeEnum {
    GANJI("1", "赶集"),
    QIXINBAO("2", "启信宝"),
    TIANYANCHA("3", "天眼查"),
    ;

    private String code;
    private String msg;

    SourceTypeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static SourceTypeEnum getMsg(String code) {
        Optional<SourceTypeEnum> errorOp = Arrays.asList(SourceTypeEnum.values())
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
