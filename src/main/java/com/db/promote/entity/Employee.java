package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Data
public class Employee {
    private Integer id;

    private String employeeNo;

    private Date createTime;

    private Date updateTime;
}