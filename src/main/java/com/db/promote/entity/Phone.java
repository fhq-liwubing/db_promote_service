package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/31
*/
@Data
public class Phone implements Serializable {
    private Long id;

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

    private LocalDateTime assignTime;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}