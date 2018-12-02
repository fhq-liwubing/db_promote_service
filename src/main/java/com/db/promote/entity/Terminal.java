package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Data
public class Terminal {
    private Integer id;

    private String username;

    private String password;

    private String employeeNo;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private byte[] terminalNo;
}