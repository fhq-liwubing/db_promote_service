package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Data
public class Cdkey implements Serializable {
    private Long id;

    private String cdkey;

    private String recievePhone;

    private String reciveveEmail;

    private Integer status;

    private LocalDateTime expireTime;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}