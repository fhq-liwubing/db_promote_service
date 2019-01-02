package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-02 21:31
 */
@Data
public class CdkeyVO {

    private String cdkey;

    private String receivePhone;

    private String receiveEmail;

    private String actTerminal;

    private Integer status;

    private Integer validateDays;

    private String remark;

    private String createTime;

    private String updateTime;

}
