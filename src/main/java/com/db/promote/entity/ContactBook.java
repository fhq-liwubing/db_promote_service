package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Data
public class ContactBook implements Serializable {
    private Long id;

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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}