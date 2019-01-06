package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 17:09
 */
@Data
public class ContactBookVO {

    private String phoneNo;

    private String contactName;

    private String contactPhone;

    private String contactCompanyNo;

    private String contactCompanyName;

    private String contactAddress;

    private String contactEmail;

    private String contactWechat;

    private Integer state;

    private String remark;

    private String createTime;

    private String updateTime;

}
