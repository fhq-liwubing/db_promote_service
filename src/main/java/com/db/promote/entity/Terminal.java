package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/06
*/
@Data
public class Terminal {
    private Integer id;

    private String terminalNo;

    private String username;

    private String password;

    private String employeeNo;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}