package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-02 21:19
 */
@Data
public class PhoneVO {

    private String phoneNo;

    private String terminalNo;

    private Long dataRemain;

    private Integer callRemain;

    private Integer msgRemain;

    private String ownerName;

    private String idCardNo;

    private String wechatNo;

    private String wechatName;

    private String payPassword;

    private String assignTime;

    private Integer state;

    private String remark;

    private String createTime;

    private String updateTime;

}
