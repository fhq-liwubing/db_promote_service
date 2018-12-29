package com.db.promote.entity.vo;

import lombok.Data;

/**
 * Created by lib on 2018/12/28.
 */
@Data
public class SmsVo {

    public static final String SUCCESS ="0" ;//成功码
    /**
     * code
     * success，成功
     */
    private String code;

    /**
     * 描述
     */
    private String msg;
}
