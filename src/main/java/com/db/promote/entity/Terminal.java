package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/29
*/
@Data
public class Terminal implements Serializable {
    private Long id;

    private String terminalNo;

    private String employeeNo;

    private String imeiNo;

    private String cdkey;

    private LocalDateTime expireTime;

    private String province;

    private String city;

    private LocalDateTime assignTime;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Employee employee;

    private static final long serialVersionUID = 1L;
}