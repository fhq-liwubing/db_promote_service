package com.db.promote.param;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 16:59
 */
@Data
public class BookQueryParam {

    /**
     * 上传该通讯信息的手机号
     */
    private String phoneNo;

    private String contactPhone;

    private String contactName;

    private String contactCompanyName;

    private String contactCompanyNo;

    private String contactEmail;

    private String contactWechat;

    private String remark;

}
