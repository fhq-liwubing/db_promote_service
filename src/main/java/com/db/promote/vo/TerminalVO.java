package com.db.promote.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2018-12-29 16:26
 */
@Data
public class TerminalVO {

    private String terminalNo;

    private String employeeName;

    private String imeiNo;

    private String cdkey;

    private LocalDateTime expireTime;

    private String province;

    private String city;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
